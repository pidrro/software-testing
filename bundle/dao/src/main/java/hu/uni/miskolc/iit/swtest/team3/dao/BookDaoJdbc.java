package hu.uni.miskolc.iit.swtest.team3.dao;

import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.service.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoJdbc implements BookDao {

    private static final String SELECT = "SELECT * FROM books";
    private static final String SELECT_BY_ID = "SELECT * FROM books WHERE isbn = :isbn";
    private static final String INSERT = "INSERT INTO books (isbn, author, title, description, language) values (:isbn, :author, :title, :description, :language)";
    private static final String UPDATE_BY_ID = "UPDATE books SET isbn=:isbn, author=:author, title=:title, description=:description, language=:language WHERE isbn=:isbn";
    private static final String DELETE_BY_ID = "DELETE FROM books WHERE isbn=:isbn";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    RowMapper<Book> rowMapper;

    @Override
    public int create(Book book) {
        return namedParameterJdbcTemplate.update(INSERT, getSqlParameterSource(book));
    }

    @Override
    public int[] create(List<Book> books) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(books.toArray(new Book[books.size()]));
        return namedParameterJdbcTemplate.batchUpdate(INSERT, params);
    }

    @Override
    public Book read(String isbn) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("isbn", isbn);
        return namedParameterJdbcTemplate.queryForObject(SELECT_BY_ID, namedParameters, rowMapper);
    }

    @Override
    public List<Book> read() {
        return jdbcTemplate.query(SELECT, rowMapper);
    }

    @Override
    public int update(Book book) {
        return namedParameterJdbcTemplate.update(UPDATE_BY_ID, getSqlParameterSource(book));
    }

    @Override
    public int[] update(List<Book> books) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(books.toArray(new Book[books.size()]));
        return namedParameterJdbcTemplate.batchUpdate(UPDATE_BY_ID, params);
    }

    @Override
    public int delete(Book book) {
        return namedParameterJdbcTemplate.update(DELETE_BY_ID, getSqlParameterSource(book));
    }

    @Override
    public int delete(String isbn) {
        return namedParameterJdbcTemplate.update(DELETE_BY_ID, new MapSqlParameterSource().addValue("isbn", isbn));
    }

    @Override
    public int[] delete(List<Book> books) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(books.toArray(new Book[books.size()]));
        return namedParameterJdbcTemplate.batchUpdate(DELETE_BY_ID, params);
    }

    private SqlParameterSource getSqlParameterSource(Book book) {

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("isbn", book.getIsbn());
        namedParameters.addValue("author", book.getAuthor());
        namedParameters.addValue("title", book.getTitle());
        namedParameters.addValue("description", book.getDescription());
        namedParameters.addValue("language", book.getLanguage());

        return namedParameters;
    }
}
