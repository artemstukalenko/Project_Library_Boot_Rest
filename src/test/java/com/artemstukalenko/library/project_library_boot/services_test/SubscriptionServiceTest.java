package com.artemstukalenko.library.project_library_boot.services_test;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionServiceTest {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    BookService bookService;

    @Autowired
    Book bookForTest;

    Subscription subscriptionForTest;

    @Test
    public void testGetAllSubscriptions() {
        subscriptionService.getAllSubscriptions();
    }

    @Test
    public void testRegisterAndDeleteSubscription() {
        bookService.addNewBook(bookForTest);

        subscriptionForTest = new Subscription("artem", bookForTest.getBookId(),
                bookForTest.getBookTitle(), bookForTest.getBookAuthor());

        Assert.assertTrue(subscriptionService.registerSubscriptionInDB(subscriptionForTest)
                && subscriptionService.deleteSubscriptionFromDB(
                        subscriptionForTest.getSubscriptionId()));

        bookService.deleteBook(bookForTest.getBookId());
    }

    @Test
    public void testFindSubscriptionById() {
        List<Subscription> existingSubscriptions = subscriptionService.getAllSubscriptions();
        Subscription foundSubscription = subscriptionService.findSubscriptionById(77);
        Assert.assertTrue(existingSubscriptions.contains(foundSubscription));
    }

    @Test
    public void testFindSubscriptionByBookId() {
        bookForTest = new Book("Book for Test", "Admin", "2021");
        bookService.addNewBook(bookForTest);

        subscriptionForTest = new Subscription("artem", bookForTest.getBookId(),
                bookForTest.getBookTitle(), bookForTest.getBookAuthor());

        subscriptionService.registerSubscriptionInDB(subscriptionForTest);

        Assert.assertTrue(subscriptionForTest.equals(subscriptionService
                .findSubscriptionByBookId(bookForTest.getBookId())));

        subscriptionService.deleteSubscriptionFromDB(subscriptionForTest.getSubscriptionId());

        bookService.deleteBook(bookForTest.getBookId());
    }
}
