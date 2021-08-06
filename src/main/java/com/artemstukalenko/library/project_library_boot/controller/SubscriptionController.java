package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class SubscriptionController {

    @Autowired
    UserService userService;

    @Autowired
    SubscriptionService subscriptionService;

    User currentUser;

    Subscription processedSubscription;

    @RequestMapping("/arrangeSubscription")
    public String arrangeSubscription(int bookId) {
        currentUser = MainController.getCurrentUser();

        processedSubscription = new Subscription(currentUser.getUsername(), bookId);

        subscriptionService.registerSubscriptionInDB(processedSubscription);
        currentUser.addSubscription(processedSubscription);

        return "subscription-arrange-form";
    }

    private boolean detailsArePresent(User userToCheck) {
        //TODO: complete details check
        return userToCheck.getUserDetails() != null;
    }

}
