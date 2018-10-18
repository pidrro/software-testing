/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uni.miskolc.iit.swtest.team3.service;

import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.BookInstance;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import java.util.List;

/**
 *
 * @author tdavi
 */
public interface LibrarianService {
    
    public List<Book> listBooks();
    public List<Borrowing> listBorrowings();
    public void addBook(Book book);
    public void addBookInstance(BookInstance bookInstance);
    public List<Borrowing> listRequests();
    public void manageRequest(Borrowing borrowing);
    
}
