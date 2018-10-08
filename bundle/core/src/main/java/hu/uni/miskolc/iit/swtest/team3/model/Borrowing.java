package hu.uni.miskolc.iit.swtest.team3.model;

public class Borrowing {

    private int borrowId;
    private BorrowStatus status;
    private Reader creator;
    private BookInstance book;
    private date creationDate;

    public Borrowing(int borrowId, BorrowStatus status, Reader creator, BookInstance book, date creationDate) {
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

    public date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(date creationDate) {
        this.creationDate = creationDate;
    }
}
