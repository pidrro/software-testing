package hu.uni.miskolc.iit.swtest.team3.dao;

import hu.uni.miskolc.iit.swtest.team3.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoJdbc implements BookDao {

    private static final String SELECT = "SELECT * FROM books";
    private static final String SELECT_BY_ISBN = "SELECT * FROM books WHERE isbn = :isbn";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    RowMapper<Book> rowMapper;

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public List<Book> create(List<Book> books) {
        return null;
    }

    @Override
    public Book read(String isbn) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("isbn", isbn);
        Book book = namedParameterJdbcTemplate.queryForObject(SELECT_BY_ISBN, namedParameters, rowMapper);
        return book;
    }

    @Override
    public List<Book> read() {
        List<Book> books = jdbcTemplate.query(SELECT, rowMapper);
        return books;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public List<Book> update(List<Book> books) {
        return null;
    }

    @Override
    public Book delete(Book book) {
        return null;
    }

    @Override
    public Book delete(String isbn) {
        return null;
    }

    @Override
    public List<Book> delete(List<Book> books) {
        return null;
    }
}
