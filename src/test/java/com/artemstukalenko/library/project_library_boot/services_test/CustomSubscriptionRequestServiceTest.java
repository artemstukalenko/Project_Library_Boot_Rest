package com.artemstukalenko.library.project_library_boot.services_test;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.CustomSubscriptionRequestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomSubscriptionRequestServiceTest {

    @Autowired
    CustomSubscriptionRequestService customRequestService;

    @Autowired
    BookService bookService;

    @Autowired
    Book bookForTest;

    CustomSubscriptionRequest customRequestForTest;

    @Test
    public void testGetAllRequests() {
        customRequestService.getAllRequests();
    }

    @Test
    public void testAddingAndDeletingCustomSubscriptionRequestToDB() {
        bookService.addNewBook(bookForTest);

        customRequestForTest = new CustomSubscriptionRequest("artem", bookForTest.getBookId(),
                bookForTest.getBookTitle(), bookForTest.getBookAuthor(), LocalDate.now(),
                LocalDate.now().plusMonths(1));

        Assert.assertTrue(customRequestService.addCustomSubscriptionRequestToDB(
                customRequestForTest) &&
                customRequestService
                        .deleteCustomSubscriptionRequestFromDB(
                                customRequestForTest.getCustomSubscriptionId()));

        bookService.deleteBook(bookForTest.getBookId());
    }

    @Test
    public void testFindRequestById() {
        bookForTest = new Book("Book for Test", "Admin", "2021");
        bookService.addNewBook(bookForTest);

        customRequestForTest = new CustomSubscriptionRequest("artem", bookForTest.getBookId(),
                bookForTest.getBookTitle(), bookForTest.getBookAuthor(), LocalDate.now(),
                LocalDate.now().plusMonths(1));

        customRequestService.addCustomSubscriptionRequestToDB(customRequestForTest);

        List<CustomSubscriptionRequest> existingRequests =
                customRequestService.getAllRequests();

        CustomSubscriptionRequest foundRequest = customRequestService.findRequestById(
                customRequestForTest.getCustomSubscriptionId());

        Assert.assertTrue(existingRequests.contains(foundRequest));

        customRequestService.deleteCustomSubscriptionRequestFromDB(
                customRequestForTest.getCustomSubscriptionId());
        bookService.deleteBook(bookForTest.getBookId());
    }
}
