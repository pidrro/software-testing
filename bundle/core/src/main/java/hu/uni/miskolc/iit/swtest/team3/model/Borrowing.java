package hu.uni.miskolc.iit.swtest.team3.model;

import java.util.GregorianCalendar;

public class Borrowing {

    private int borrowId;
    private BorrowStatus status;
    private User creator;
    private BookInstance book;
    private GregorianCalendar creationDate;

    public Borrowing(int borrowId, BorrowStatus status, User creator, BookInstance book, GregorianCalendar creationDate) {
        this.borrowId = borrowId;
        this.status = status;
        this.creator = creator;
        this.book = book;
        this.creationDate = creationDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public BookInstance getBook() {
        return book;
    }

    public void setBook(BookInstance book) {
        this.book = book;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }
}
