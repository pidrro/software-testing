package hu.uni.miskolc.iit.swtest.team3.web.controller;

import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import hu.uni.miskolc.iit.swtest.team3.model.User;
import hu.uni.miskolc.iit.swtest.team3.model.exception.UnsuccessfulOperationException;
import hu.uni.miskolc.iit.swtest.team3.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reader/")
public class ReaderController {

    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("books")
    public List<Book> listBooks() {
        return readerService.listBooks();
    }

    @GetMapping("isAvailable")
    public Boolean checkAvailability(@RequestBody Book book) {
        return readerService.checkAvailability(book);
    }

    @GetMapping("{readerId}/borrowings")
    public List<Borrowing> showBorrowings(@PathVariable("readerId") int readerId) {
        User currentReader = new User();
        currentReader.setUserId(readerId);
        return readerService.listBorrowings(currentReader);
    }

    @PostMapping("{readerId}/requestBook")
    public void requestBook(@PathVariable("readerId") int readerId,@RequestBody Book book) {
        User currentReader = new User();
        currentReader.setUserId(readerId);
        readerService.requestBook(book, currentReader);
    }

    @ExceptionHandler(UnsuccessfulOperationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void unsuccessfulOperation() {}

    @ExceptionHandler(UnsuccessfulOperationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void noAvailableCopies() {}
}
