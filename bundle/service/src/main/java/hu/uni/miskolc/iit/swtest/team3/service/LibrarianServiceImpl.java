package hu.uni.miskolc.iit.swtest.team3.service;

import hu.uni.miskolc.iit.swtest.team3.dao.BookDao;
import hu.uni.miskolc.iit.swtest.team3.dao.BorrowingDao;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import static hu.uni.miskolc.iit.swtest.team3.model.BorrowStatus.REQUESTED;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tdavi
 */

@Service
public class LibrarianServiceImpl implements LibrarianService {

    private BookDao bookDao;
    private BorrowingDao borrowingDao;

    @Autowired
    public LibrarianServiceImpl(BookDao bookDao, BorrowingDao borrowingDao) {
        this.bookDao = bookDao;
        this.borrowingDao = borrowingDao;
    }
    
    @Override
    public List<Book> listBooks() {
        return bookDao.read();
    }

    @Override
    public List<Borrowing> listBorrowings() {
        return borrowingDao.read();
    }

    @Override
    public void addBook(Book book) {
        bookDao.create(book);
    }

    @Override
    public void addBookInstance(Book book) {
        String isbn = book.getIsbn();        
        Book updatedBook = bookDao.read(isbn);
        updatedBook.setAvailableCopies(book.getAvailableCopies());
        bookDao.update(updatedBook);
    }

    @Override
    public List<Borrowing> listRequests() {
        List<Borrowing> borrowings = borrowingDao.read();
        List<Borrowing> requestedBorrowing = new ArrayList<>();
        for(int i=0;i<borrowings.size();i++){
            if(borrowings.get(i).getStatus() == REQUESTED){
                requestedBorrowing.add(borrowings.get(i));
            }
        }

        return requestedBorrowing;
    }
        
    @Override
    public void manageRequest(Borrowing borrowing) {
        int borrowId = borrowing.getBorrowId();
        Borrowing fromDaoBorrowing = borrowingDao.read(borrowId);
        if(borrowing.getStatus() != fromDaoBorrowing.getStatus()){
            fromDaoBorrowing.setStatus(borrowing.getStatus());
        }
        borrowingDao.update(fromDaoBorrowing);
    }
        
}
