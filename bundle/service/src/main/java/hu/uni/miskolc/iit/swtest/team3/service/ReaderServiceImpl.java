package hu.uni.miskolc.iit.swtest.team3.service;

import hu.uni.miskolc.iit.swtest.team3.dao.BookDao;
import hu.uni.miskolc.iit.swtest.team3.dao.BorrowingDao;
import hu.uni.miskolc.iit.swtest.team3.model.*;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    private BookDao bookDao;
    private BorrowingDao borrowingDao;

    public ReaderServiceImpl(BookDao bookDao, BorrowingDao borrowingDao){
        this.bookDao=bookDao;
        this.borrowingDao=borrowingDao;
    }

    @Override
    public List<Book> listBooks() { return bookDao.read(); }

    @Override
    public List<Borrowing> listBorrowings() {return borrowingDao.read();}

    @Override
    public void requestBook(Book book) {
        try {
            Borrowing fromBorrowingDao = borrowingDao.read(book);
            if (fromBorrowingDao.getStatus() != BorrowStatus.RETURNED) {
                fromBorrowingDao.setStatus(BorrowStatus.REQUESTED);
                borrowingDao.update(fromBorrowingDao);}
            }
            catch(DataAccessException exception){return;}
    }
    @Override
    public Boolean checkAvailability(Book book){
        try{Borrowing fromBorrowingDao =borrowingDao.read(book);
            if(fromBorrowingDao.getStatus() == BorrowStatus.RETURNED){return Boolean.TRUE;}
            else return Boolean.FALSE;}
        catch (DataAccessException exception){return Boolean.FALSE;}
    }

}
