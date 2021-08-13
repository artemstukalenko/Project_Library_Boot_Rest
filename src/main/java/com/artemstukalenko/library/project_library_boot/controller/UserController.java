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

//    @ModelAttribute
//    public void addEssentialAttributes(Model model) {
//        model.addAttribute("locale", controlledView);
//        currentUser = mainController.getCurrentUser();
//        model.addAttribute("currentUser", currentUser);
//    }

    @RequestMapping("/viewSubscriptions/{username}")
    public List<Subscription> getUserSubscriptionsPage(@PathVariable("username") String username) {
        return userService.findUserByUsername(username).getSubscriptionList();
    }

    @RequestMapping("/payPenalty")
    public String payPenalty(Model model) {
        currentUser = mainController.getCurrentUser();
        model.addAttribute("userPenaltySum", currentUser.getUserDetails().getUserPenalty());

        return "pay-penalty-form";
    }

    @RequestMapping("/confirmPayment")
    public String confirmPayment(@RequestParam("userSum") int userSum, Model model) {
        userService.updatePenaltyInfo(currentUser.getUsername(), currentUser.getUserDetails().getUserPenalty() - userSum);
        currentUser = userService.findUserByUsername(currentUser.getUsername());
        model.addAttribute("currentUser", currentUser);

        return "homepage";
    }

}
