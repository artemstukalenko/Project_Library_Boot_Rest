package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    User currentUser;

    @RequestMapping("/viewSubscriptions")
    public String getUserSubscriptionsPage(Model model) {
        currentUser = MainController.getCurrentUser();
        List<Subscription> userSubscriptionList = currentUser.getSubscriptionList();

        model.addAttribute("userSubscriptionList", userSubscriptionList);

        return "my-subscriptions";
    }
}
