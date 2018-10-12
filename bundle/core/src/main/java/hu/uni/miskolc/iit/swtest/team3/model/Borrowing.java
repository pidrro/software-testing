package hu.uni.miskolc.iit.swtest.team3.model;

import java.util.Date;

public class Borrowing {

    private int borrowId;
    private BorrowStatus status;
    private Reader creator;
    private BookInstance book;
    private Date creationDate;

    public Borrowing(int borrowId, BorrowStatus status, Reader creator, BookInstance book, Date creationDate) {
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

    public Reader getCreator() {
        return creator;
    }

    public void setCreator(Reader creator) {
        this.creator = creator;
    }

    public BookInstance getBook() {
        return book;
    }

    public void setBook(BookInstance book) {
        this.book = book;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
