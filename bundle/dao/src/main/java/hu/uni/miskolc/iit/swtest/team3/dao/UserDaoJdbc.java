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
public class UserDaoJdbc implements UserDao {

    private static final String SELECT = "SELECT * FROM user";
    private static final String SELECT_BY_ID = "SELECT * FROM user WHERE userid = :userid";
    private static final String INSERT = "INSERT INTO user (userid, fname, lname, bdate, town, street, hnumber) values (:userid, :fname, :lname, :bdate, :town, :street, :hnumber)";
    private static final String UPDATE_BY_ID = "UPDATE user SET userid=:userid, fname=:fname, lname=:lname, bdate=:bdate, town=:town street=:street, hnumber=:hnumber WHERE userid=:userid";
    private static final String DELETE_BY_ID = "DELETE FROM user WHERE userid=:userid";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    final
    RowMapper<User> rowMapper;

    @Autowired
    public UserDaoJdbc(RowMapper<User> rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public int create(User user) {
        return namedParameterJdbcTemplate.update(INSERT, getSqlParameterSource(user));
    }

    @Override
    public int[] create(List<User> user) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(books.toArray());
        return namedParameterJdbcTemplate.batchUpdate(INSERT, params);
    }

    @Override
    public User read(String userid) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("userid", userid);
        return namedParameterJdbcTemplate.queryForObject(SELECT_BY_ID, namedParameters, rowMapper);
    }

    @Override
    public List<User> read() {
        return jdbcTemplate.query(SELECT, rowMapper);
    }

    @Override
    public int update(User user) {
        return namedParameterJdbcTemplate.update(UPDATE_BY_ID, getSqlParameterSource(book));
    }

    @Override
    public int[] update(List<User> user) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(user.toArray());
        return namedParameterJdbcTemplate.batchUpdate(UPDATE_BY_ID, params);
    }

    @Override
    public int delete(User user) {
        return namedParameterJdbcTemplate.update(DELETE_BY_ID, getSqlParameterSource(user));
    }

    @Override
    public int delete(String userid) {
        return namedParameterJdbcTemplate.update(DELETE_BY_ID, new MapSqlParameterSource().addValue("userid", userid));
    }

    @Override
    public int[] delete(List<User> user) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(user.toArray());
        return namedParameterJdbcTemplate.batchUpdate(DELETE_BY_ID, params);
    }

    private SqlParameterSource getSqlParameterSource(User user) {

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("userid", user.getUserID());
        namedParameters.addValue("fname", user.getFName());
        namedParameters.addValue("lname", user.getLName());
        namedParameters.addValue("bdate", user.getBDate());
        namedParameters.addValue("town", user.getTown());
        namedParameters.addValue("street", user.getStreet());
        namedParameters.addValue("hnumber", user.getHNumber());

        return namedParameters;
    }
}
