package hu.uni.miskolc.iit.swtest.team3.web.controller;

import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import hu.uni.miskolc.iit.swtest.team3.model.User;
import hu.uni.miskolc.iit.swtest.team3.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/reader/")
public class ReaderController {

    final
    ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("books")
    @ResponseBody
    public List<Book> listBooks() {
        return readerService.listBooks();
    }

    @GetMapping("{userId}/borrowings")
    @ResponseBody
    public List<Borrowing> listBorrowing(@PathVariable("userId") int userId) {
        User reader = new User();
        reader.setUserId(userId);

        return readerService.listBorrowings(reader);
    }
}
