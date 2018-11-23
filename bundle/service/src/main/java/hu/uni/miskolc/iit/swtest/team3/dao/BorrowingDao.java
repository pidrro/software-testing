package hu.uni.miskolc.iit.swtest.team3.dao;

import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.User;

import java.util.List;

/**
 *
 * @author tdavi
 */
public interface BorrowingDao {
    
    int create(Borrowing borrowing);
    
    int[] create(List<Borrowing> borrowings);

    Borrowing read(int borrowId);

    Borrowing read(Book book);

    List<Borrowing> read();

    List<Borrowing> readByUser(User creator);

    int update(Borrowing borrowing);

    int[] update(List<Borrowing> borrowings);

    int delete(Borrowing borrowing);

    int delete(int borrowId);

    int[] delete(List<Borrowing> borrowings);
    
}
