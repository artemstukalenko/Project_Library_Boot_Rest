package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.exceptions.BookIsTakenException;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {

    @Autowired
    UserService userService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    BookService bookService;

    User currentUser;

    Book currentBook;

    Subscription processedSubscription;

    @RequestMapping("/arrangeSubscription")
    public String arrangeSubscription(int bookId) throws BookIsTakenException {
        currentUser = MainController.getCurrentUser();
        currentBook = bookService.findBookById(bookId);

        if (bookIsTaken()) {
            throw new BookIsTakenException();
        }

        processedSubscription = new Subscription(currentUser.getUsername(), bookId,
                currentBook.getBookTitle(), currentBook.getBookAuthor());


        subscriptionService.registerSubscriptionInDB(processedSubscription);
        bookService.setTaken(bookId, true);
        currentUser.addSubscription(processedSubscription);

        return "subscription-arrange-form";
    }

    private boolean bookIsTaken() {
        return  currentBook.getTaken();
    }

    @RequestMapping("/returnBook")
    public String returnBook(@RequestParam("subscriptionId") int id) {
        processedSubscription = subscriptionService.findSubscriptionById(id);

        subscriptionService.deleteSubscriptionFromDB(processedSubscription
                .getSubscriptionId());
        bookService.setTaken(processedSubscription.getBookId(), false);

        return "homepage";
    }

    private boolean detailsArePresent(User userToCheck) {
        //TODO: complete details check
        return userToCheck.getUserDetails() != null;
    }

}
