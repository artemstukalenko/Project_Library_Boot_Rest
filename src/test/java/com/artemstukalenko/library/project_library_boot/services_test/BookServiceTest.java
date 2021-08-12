package com.artemstukalenko.library.project_library_boot.services_test;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    Book bookForTest;

    @Test
    public void testGetAllBooks() {
        bookService.getAllBooks();
    }

    @Test
    public void testAddAndDeleteNewBook() {
        Assert.assertTrue(bookService.addNewBook(bookForTest) &&
                bookService.deleteBook(bookForTest.getBookId()));
    }

    @Test
    public void testFindBookById() {
        List<Book> existingBooks = bookService.getAllBooks();
        Book foundBook = bookService.findBookById(5); //pass id for test here
        Assert.assertTrue(existingBooks.contains(foundBook));
    }

    @Test
    public void testSetTaken() {
        int id = 2;
        boolean beforeSet = bookService.findBookById(id).getTaken();

        bookService.setTaken(id, !(bookService.findBookById(id).getTaken()));

        boolean afterSet = bookService.findBookById(id).getTaken();

        Assert.assertTrue(beforeSet != afterSet);
        bookService.setTaken(id, beforeSet);
    }
}
