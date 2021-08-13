package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;

import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.CustomSubscriptionRequestService;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    UserService userService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    CustomSubscriptionRequestService customSubscriptionRequestService;

    @Autowired
    BookService bookService;

    @Autowired
    MainController mainController;

    User currentUser;

    Book currentBook;

    Subscription processedSubscription;

    @PostMapping("/arrangeSubscription/{username}/{bookId}")
    public List<Subscription> arrangeSubscription(@PathVariable("username") String username,
                                                  @PathVariable("bookId") int bookId) {
        currentBook = bookService.findBookById(bookId);
        currentUser = userService.findUserByUsername(username);

        processedSubscription = new Subscription(currentUser.getUsername(), bookId,
                currentBook.getBookTitle(), currentBook.getBookAuthor());


        subscriptionService.registerSubscriptionInDB(processedSubscription);
        bookService.setTaken(bookId, true);
        currentUser.addSubscription(processedSubscription);

        return subscriptionService.getAllSubscriptions();
    }

    @PutMapping("/returnBook/{subscriptionId}")
    public List<Subscription> returnBook(@PathVariable("subscriptionId") int id) {
        processedSubscription = subscriptionService.findSubscriptionById(id);

        subscriptionService.deleteSubscriptionFromDB(processedSubscription
                .getSubscriptionId());
        bookService.setTaken(processedSubscription.getBookId(), false);

        return subscriptionService.getAllSubscriptions();
    }

    @PostMapping("/registerRequest/{username}/{bookId}/{startDate}/{endDate}")
    public List<CustomSubscriptionRequest> registerCustomRequest(@PathVariable("startDate") String startDate,
                                        @PathVariable("endDate") String endDate,
                                        @PathVariable("username") String username,
                                        @PathVariable("bookId") int bookId) {

        Book bookToMakeRequestOn = bookService.findBookById(bookId);

        CustomSubscriptionRequest processedRequest =
                new CustomSubscriptionRequest(username, bookId,
                        bookToMakeRequestOn.getBookTitle(), bookToMakeRequestOn.getBookAuthor(),
                        LocalDate.parse(startDate), LocalDate.parse(endDate));

        customSubscriptionRequestService.addCustomSubscriptionRequestToDB(processedRequest);

        return customSubscriptionRequestService.getAllRequests();
    }
}
