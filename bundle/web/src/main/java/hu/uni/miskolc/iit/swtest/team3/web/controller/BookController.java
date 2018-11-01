package hu.uni.miskolc.iit.swtest.team3.web.controller;

import hu.uni.miskolc.iit.swtest.team3.service.dao.BookDao;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    final
    BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/book/create")
    @ResponseBody
    public Book createBook(@RequestBody Book book) {
        bookDao.create(book);
        return book;
    }

    @RequestMapping("/book/create/list")
    @ResponseBody
    public List<Book> createBook(@RequestBody List<Book> books) {
        bookDao.create(books);
        return books;
    }

    @RequestMapping("/book/read")
    @ResponseBody
    public List<Book> getBooks() {
        return bookDao.read();
    }

    @RequestMapping("/book/read/{isbn}")
    @ResponseBody
    public Book getBooks(@PathVariable String isbn) {
        return bookDao.read(isbn);

    }

    @RequestMapping("/book/update")
    @ResponseBody
    public Book updateBook(@RequestBody Book book) {
        bookDao.update(book);
        return book;
    }

    @RequestMapping("/book/update/list")
    @ResponseBody
    public List<Book> updateBook(@RequestBody List<Book> books) {
        bookDao.update(books);
        return books;
    }

    @RequestMapping("/book/delete")
    @ResponseBody
    public Book deleteBook(@RequestBody Book book) {
        bookDao.delete(book);
        return book;
    }

    @RequestMapping("/book/delete/list")
    @ResponseBody
    public List<Book> deleteBook(@RequestBody List<Book> books) {
        bookDao.delete(books);
        return books;
    }

}
