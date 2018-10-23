package hu.uni.miskolc.iit.swtest.team3.service;

import java.util.List;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;


public interface ReaderService{

    List<Book> listBooks();
    List<Borrowing> listBorrowings();
    void requestBook(Book book);
    Boolean checkAvailability(Book book);

}
