/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uni.miskolc.iit.swtest.team3.service;

import hu.uni.miskolc.iit.swtest.team3.model.Book;
import hu.uni.miskolc.iit.swtest.team3.model.Borrowing;
import java.util.List;

/**
 *
 * @author tdavi
 */
public interface LibrarianService {
    
    List<Book> listBooks();
    List<Borrowing> listBorrowings();
    void addBook(Book book);
    void addBookInstance(Book book);
    List<Borrowing> listRequests();
    void manageRequest(Borrowing borrowing);
    
}
