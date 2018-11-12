package hu.uni.miskolc.iit.swtest.team3.model.test;

import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.BorrowStatus;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import hu.uni.miskolc.iit.swtest.team3.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

public class BorrowingTest {

    private static final int TEST_BORROWID = 1;
    private static final BorrowStatus TEST_BORROWSTATUS = BorrowStatus.RETURNED;
    private static final User TEST_CREATOR = new User(66, "$2a$gr8hashm8", "Such Test", "test@notgmail.hu", Boolean.FALSE);
    private static final Book TEST_BOOK = new Book("811326746-8", "Luther Prince", "Nice title", "Nicer description", "polish", 6);
    private static final GregorianCalendar TEST_CREATIONDATE = new GregorianCalendar();

    @Test
    public void constructorTest() {
        Borrowing borrowingToTest = new Borrowing(TEST_BORROWID, TEST_BORROWSTATUS, TEST_CREATOR, TEST_BOOK, TEST_CREATIONDATE);

        Assert.assertEquals(TEST_BORROWID, borrowingToTest.getBorrowId());
        Assert.assertEquals(TEST_BORROWSTATUS, borrowingToTest.getStatus());
        Assert.assertEquals(TEST_CREATOR, borrowingToTest.getCreator());
        Assert.assertEquals(TEST_BOOK, borrowingToTest.getBook());
        Assert.assertEquals(TEST_CREATIONDATE, borrowingToTest.getCreationDate());
    }

    @Test
    public void setterTest() {
        Borrowing borrowingToTest = new Borrowing();
        borrowingToTest.setBorrowId(TEST_BORROWID);
        borrowingToTest.setStatus(TEST_BORROWSTATUS);
        borrowingToTest.setCreator(TEST_CREATOR);
        borrowingToTest.setBook(TEST_BOOK);
        borrowingToTest.setCreationDate(TEST_CREATIONDATE);

        Assert.assertEquals(TEST_BORROWID, borrowingToTest.getBorrowId());
        Assert.assertEquals(TEST_BORROWSTATUS, borrowingToTest.getStatus());
        Assert.assertEquals(TEST_CREATOR, borrowingToTest.getCreator());
        Assert.assertEquals(TEST_BOOK, borrowingToTest.getBook());
        Assert.assertEquals(TEST_CREATIONDATE, borrowingToTest.getCreationDate());
    }
}
