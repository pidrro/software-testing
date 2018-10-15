package hu.uni.miskolc.iit.swtest.team3.service;

import java.util.List;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;


public interface ReaderService{

    public List<Book> listBooks();
    public List<Borrowing> listBorrowings();
    public void requestBook(Book book);
    public void checkAvailability();

}
