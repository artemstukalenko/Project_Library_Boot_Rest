package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.exceptions.BookIsTakenException;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.CustomSubscriptionRequestService;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
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
    FirstView controlledView;

    @Autowired
    MainController mainController;

    User currentUser;

    Book currentBook;

    Subscription processedSubscription;

    @ModelAttribute
    public void addTextInformation(Model model) {
        model.addAttribute("locale", controlledView);
        currentUser = mainController.getCurrentUser();
        System.out.println("USER IN SUBSCRIPTION CONTROLLER: " + currentUser);
        model.addAttribute("currnetUser", currentUser);
    }

    @RequestMapping("/arrangeSubscription")
    public String arrangeSubscription(int bookId, Model model) {
        currentBook = bookService.findBookById(bookId);

        processedSubscription = new Subscription(currentUser.getUsername(), bookId,
                currentBook.getBookTitle(), currentBook.getBookAuthor());


        subscriptionService.registerSubscriptionInDB(processedSubscription);
        bookService.setTaken(bookId, true);
        currentUser.addSubscription(processedSubscription);

        model.addAttribute("userSubscriptionList", userService.
                findUserByUsername(currentUser.getUsername()).getSubscriptionList());

        return "my-subscriptions";
    }

    @RequestMapping("/returnBook")
    public String returnBook(@RequestParam("subscriptionId") int id, Model model) {
        processedSubscription = subscriptionService.findSubscriptionById(id);

        subscriptionService.deleteSubscriptionFromDB(processedSubscription
                .getSubscriptionId());
        bookService.setTaken(processedSubscription.getBookId(), false);

        model.addAttribute("userSubscriptionList", userService.
                findUserByUsername(currentUser.getUsername()).getSubscriptionList());

        return "my-subscriptions";
    }

    @RequestMapping("/arrangeCustomRequest")
    public String getCustomSubscriptionRequestArrangeForm(int bookId,
                                                          Model model) {
        currentBook = bookService.findBookById(bookId);

        if (currentBook.getTaken()) {
            model.addAttribute("currentSubscription",
                    subscriptionService.findSubscriptionByBookId(bookId));
        }

        model.addAttribute("currentBook", currentBook);
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("notTaken", !(currentBook.getTaken()));

        return "custom-subscription-request-arrange-form";
    }

    @RequestMapping("/registerRequest")
    public String registerCustomRequest(@RequestParam("startDate") String startDate,
                                        @RequestParam("endDate") String endDate,
                                        Model model) {

        CustomSubscriptionRequest processedRequest =
                new CustomSubscriptionRequest(currentUser.getUsername(), currentBook.getBookId(),
                        currentBook.getBookTitle(), currentBook.getBookAuthor(),
                        LocalDate.parse(startDate), LocalDate.parse(endDate));

        customSubscriptionRequestService.addCustomSubscriptionRequestToDB(processedRequest);

        model.addAttribute("userSubscriptionList", userService.
                findUserByUsername(currentUser.getUsername()).getSubscriptionList());

        return "my-subscriptions";
    }
}
