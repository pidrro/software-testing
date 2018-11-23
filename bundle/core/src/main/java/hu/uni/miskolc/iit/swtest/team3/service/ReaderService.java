package hu.uni.miskolc.iit.swtest.team3.service;

import java.util.List;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import hu.uni.miskolc.iit.swtest.team3.model.User;


public interface ReaderService{

    List<Book> listBooks();
    List<Borrowing> listBorrowings(User reader);
    void requestBook(Book book, User reader);
    Boolean checkAvailability(Book book);

}
