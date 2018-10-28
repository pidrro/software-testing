package hu.uni.miskolc.iit.swtest.team3.web.controller;

import hu.uni.miskolc.iit.swtest.team3.dao.BookDao;
import hu.uni.miskolc.iit.swtest.team3.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookDao bookDao;

    @GetMapping("/book/read")
    @ResponseBody
    public List<Book> getBooks() {
        return bookDao.read();
    }

    @GetMapping("/book/read/{isbn}")
    @ResponseBody
    public Book getBooks(@PathVariable String isbn) {
        return bookDao.read(isbn);

    }

}
