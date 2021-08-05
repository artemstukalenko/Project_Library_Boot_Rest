package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {

    @Autowired
    UserService userService;

    @RequestMapping("/arrangeSubscription")
    public String arrangeSubscription(String username, int bookId) {

        User userWhoWantsABook = userService.findUserByUsername(username);


        return "subscription-arrange-form";
    }

    private boolean detailsArePresent(User userToCheck) {
        //TODO: complete details check
        return userToCheck.getUserDetails() != null;
    }

}
