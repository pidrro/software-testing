package hu.uni.miskolc.iit.swtest.team3.dao;

import hu.uni.miskolc.iit.swtest.team3.model.Book;

import java.util.List;

public interface BookDao {

    public Book create(Book book);
    public List<Book> create(List<Book> books);
    public Book read(String isbn);
    public List<Book> read();
    public Book update(Book book);
    public List<Book> update(List<Book> books);
    public Book delete(Book book);
    public Book delete(String isbn);
    public List<Book> delete(List<Book> books);

}
