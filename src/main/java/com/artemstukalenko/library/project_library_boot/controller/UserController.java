package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    FirstView controlledView;

    @Autowired
    UserService userService;

    @Autowired
    MainController mainController;

    User currentUser;

    @RequestMapping("/viewSubscriptions/{username}")
    public List<Subscription> getUserSubscriptionsPage(@PathVariable("username") String username) {
        return userService.findUserByUsername(username).getSubscriptionList();
    }

    @PutMapping("/confirmPayment/{username}/{updateSum}")
    public User confirmPayment(@PathVariable("username") String username,
                                 @PathVariable("updateSum") String updateSum) {
        int userSum = Integer.parseInt(updateSum);
        currentUser = userService.findUserByUsername(username);
        userService.updatePenaltyInfo(currentUser.getUsername(), currentUser.getUserDetails().getUserPenalty() - userSum);

        return currentUser;

    }

}
