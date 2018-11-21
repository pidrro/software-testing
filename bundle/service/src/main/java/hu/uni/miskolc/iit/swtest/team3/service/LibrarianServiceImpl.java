package hu.uni.miskolc.iit.swtest.team3.service;

import hu.uni.miskolc.iit.swtest.team3.dao.BookDao;
import hu.uni.miskolc.iit.swtest.team3.dao.BorrowingDao;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import static hu.uni.miskolc.iit.swtest.team3.model.BorrowStatus.REQUESTED;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import java.util.ArrayList;
import java.util.List;

import hu.uni.miskolc.iit.swtest.team3.model.exception.UnsuccessfulOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        try {
            bookDao.create(book);
        } catch (DataAccessException exception) {
            throw new UnsuccessfulOperationException("Could not add book!", exception);
        }
    }

    @Override
    public void addBookInstance(Book book) {
        String isbn = book.getIsbn();
        try {
            Book bookToUpdate = bookDao.read(isbn);
            bookToUpdate.setAvailableCopies(bookToUpdate.getAvailableCopies() + 1);
            bookDao.update(bookToUpdate);
        } catch (DataAccessException | IllegalArgumentException exception) {
            throw new UnsuccessfulOperationException("Could not add book instance!", exception);
        }
    }

    @Override
    public List<Borrowing> listRequests() {
        List<Borrowing> borrowings = borrowingDao.read();
        List<Borrowing> requestedBorrowing = new ArrayList<>();

        for(Borrowing borrowing : borrowings){
            if(borrowing.getStatus() == REQUESTED){
                requestedBorrowing.add(borrowing);
            }
        }

        return requestedBorrowing;
    }
        
    @Override
    public void manageRequest(Borrowing borrowing) {
        int borrowId = borrowing.getBorrowId();

        try {
            Borrowing fromDaoBorrowing = borrowingDao.read(borrowId);
            if (borrowing.getStatus() != fromDaoBorrowing.getStatus()) {
                fromDaoBorrowing.setStatus(borrowing.getStatus());
            }
            borrowingDao.update(fromDaoBorrowing);
        } catch (DataAccessException exception) {
            throw new UnsuccessfulOperationException("Could not change the status of the request!", exception);
        }
    }
}
