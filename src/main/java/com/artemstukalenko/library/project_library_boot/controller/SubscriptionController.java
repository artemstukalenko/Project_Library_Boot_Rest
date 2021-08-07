package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.exceptions.BookIsTakenException;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    FirstView controlledView;

    User currentUser;

    Book currentBook;

    Subscription processedSubscription;

    @ModelAttribute
    public void addTextInformation(Model model) {
        model.addAttribute("locale", controlledView);
    }

    @RequestMapping("/arrangeSubscription")
    public String arrangeSubscription(int bookId, Model model) throws BookIsTakenException {
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

        model.addAttribute("userSubscriptionList", userService.
                findUserByUsername(currentUser.getUsername()).getSubscriptionList());

        return "my-subscriptions";
    }

    private boolean bookIsTaken() {
        return  currentBook.getTaken();
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

    private boolean detailsArePresent(User userToCheck) {
        //TODO: complete details check
        return userToCheck.getUserDetails() != null;
    }

}
