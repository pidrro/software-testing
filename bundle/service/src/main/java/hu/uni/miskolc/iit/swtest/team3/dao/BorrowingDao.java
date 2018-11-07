/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uni.miskolc.iit.swtest.team3.dao;

import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import java.util.List;

/**
 *
 * @author tdavi
 */
public interface BorrowingDao {
    
    int create(Borrowing borrowing);
    
    int[] create(List<Borrowing> books);

    Borrowing read(int borrowId);

    List<Borrowing> read();

    int update(Borrowing borrowing);

    int[] update(List<Borrowing> borrowings);

    int delete(Borrowing borrowing);

    int delete(int borrowId);

    int[] delete(List<Borrowing> borrowings);
    
}
