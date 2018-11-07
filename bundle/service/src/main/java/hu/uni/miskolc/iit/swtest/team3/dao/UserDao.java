/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uni.miskolc.iit.swtest.team3.dao;

import hu.uni.miskolc.iit.swtest.team3.model.User;
import java.util.List;

/**
 *
 * @author tdavi
 */
public interface UserDao {
    
    int create(User user);
    
    User read(String userId);

    List<User> read();

    int update(User user);

    int delete(User user);

    int delete(String userId);

}
