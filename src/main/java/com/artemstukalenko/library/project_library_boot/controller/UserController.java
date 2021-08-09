package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    FirstView controlledView;

    @Autowired
    UserService userService;

    User currentUser;

    @ModelAttribute
    public void addEssentialAttributes(Model model) {
        model.addAttribute("locale", controlledView);
        currentUser = MainController.getCurrentUser();
        model.addAttribute("currentUser", currentUser);
    }

    @RequestMapping("/viewSubscriptions")
    public String getUserSubscriptionsPage(Model model) {
        model.addAttribute("userSubscriptionList", userService.
                findUserByUsername(currentUser.getUsername()).getSubscriptionList());

        return "my-subscriptions";
    }

    @RequestMapping("/payPenalty")
    public String payPenalty(Model model) {
        model.addAttribute("userPenaltySum", currentUser.getUserDetails().getUserPenalty());

        return "pay-penalty-form";
    }

    @RequestMapping("/confirmPayment")
    public String confirmPayment(@RequestParam("userSum") int userSum) {
        System.out.println(userSum);

        return "homepage";
    }

}
