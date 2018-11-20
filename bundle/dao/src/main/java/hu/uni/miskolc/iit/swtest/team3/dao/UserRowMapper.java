package hu.uni.miskolc.iit.swtest.team3.dao;


import hu.uni.miskolc.iit.swtest.team3.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt("userId"));
        user.setPasswordHash(resultSet.getString("passwordHash"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setLibrarian(resultSet.getBoolean("librarian"));

        return user;
    }
}
