package bundle.service.src.test.java.hu.uni.miskolc.iit.swtest.team3.service;

import hu.uni.miskolc.iit.swtest.team3.dao.*;
import hu.uni.miskolc.iit.swtest.team3.model.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.*;
import org.mockito.Mockito;
import org.springframework.dao.DataAccessException;

import static org.mockito.Mockito.*;

public class LibrarianServiceImplTest{
    private List<Book> testBookList = new ArrayList<>();
    private Book testBook = new Book();
    private User testUser = new User();
    private Borrowing testBorrowing= new Borrowing();
    ReaderServiceImpl readerServiceImpl = null;
    LibrarianServiceImplTest librarianServiceImpl = null;

    BookDao testBookDao = Mockito.mock(BookDao.class);
    BorrowingDao testBorrowingDao = Mockito.mock(BorrowingDao.class);

    @BeforeClass
    public void init() {
        readerServiceImpl = new ReaderServiceImpl(testBookDao, testBorrowingDao);

        testBook.setIsbn("12-114-01010-0");
        testBook.setAuthor("some one");
        testBook.setTitle("The beauty and the beast");
        testBook.setDescription("Adventures, Drama");
        testBook.setLanguage("English");
        testBook.setAvailableCopies(5);

        testBookList.add(testBook);

        testBorrowing.setBorrowId(1);
        testBorrowing.setStatus(BorrowStatus.RETURNED);
        testBorrowing.setCreatorId(6);
        testBorrowing.setBookIsbn("123456789-8");
        testBorrowing.setCreationDate(TEST_CREATIONDATE);

        testBorrowingList.add(testBorrowing);

        testUser.setUserId(6);
        testUser.setPasswordHash("killthemall");
        testUser.setName("some body");
        testUser.setEmail("some.body@miskolc-uni.hu");
        testUser.setLibrarian(Boolean.TRUE);
    }

    @Test
    public void testListBooks() {
        when(testBookDao.read()).thenReturn(testBookList);

        Assert.assertEquals(testBookList, librarianServiceImpl.listBooks());
        verify(testBookDao).read();
    }

    @Test
    public void testListBorrowings() {
        when(testBorrowingDao.readByUser(testUser)).thenReturn(testBorrowingList);

        Assert.assertEquals(testBorrowingList, librarianServiceImpl.listBorrowings());
        verify(testBorrowingDao).readByUser(testUser);
    }


    @Test
    public void testListRequests() {
        when(testBorrowingDao.readByUser(testUser)).thenReturn(testListRequests);

        Assert.assertEquals(testListRequests, librarianServiceImpl.listRequests());
        verify(testBorrowingDao).readByUser(testUser);
    }

    @Test
    public void TestAddBook(){
        when(testBookDao.create(any(Book.class))).thenReturn(testBook);
        librarianServiceImpl.addBook(testBook);
    }
    @Test
    public void TestAddBookInstance(){
        when(testBookDao.create(any(Book.class))).thenReturn(testBook);
        librarianServiceImpl.addBookInstance(testBook);
    }

    @Test
    public void TestManageRequest(){
        when(testBorrowingDao.readByUser(testUser)).thenReturn(testBook);
        librarianServiceImpl.manageRequest(testBorrowing);
    }
}
