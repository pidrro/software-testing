package hu.uni.miskolc.iit.swtest.team3.service;

import hu.uni.miskolc.iit.swtest.team3.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class DummyReaderServiceImpl implements ReaderService {

    private static List<Book> books = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    static
    {
        books.add(new Book("A0132543543", "Cory Doctorow", "Kis Testvér", "Dummy Description", "hungarian", 2));
        books.add(new Book("A0157464354", "Kurt Vonnegut", "Halálnál is rosszabb", "A bit longer dummy description", "hungarian", 15));

        users.add(new User(69, "it_is_plaintext", "FakeryFake", "fakery.fake@fakemail.ros", false));
    }

    @Override
    public List<Book> listBooks() {
        return books;
    }

    @Override
    public List<Borrowing> listBorrowings() {
        List<Borrowing> dummyBorrowings = new ArrayList<>();
        dummyBorrowings.add(new Borrowing(88, BorrowStatus.BORROWED, users.get(0), books.get(0),
                new GregorianCalendar(2017,9,1)));
        return dummyBorrowings;
    }

    @Override
    public void requestBook(Book book) {
    }

    @Override
    public Boolean checkAvailability(Book book) {
        return Boolean.FALSE;
    }
}
