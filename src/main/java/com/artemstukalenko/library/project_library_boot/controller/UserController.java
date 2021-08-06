package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    FirstView controlledView = new FirstView();

    User currentUser;

    @RequestMapping("/viewSubscriptions")
    public String getUserSubscriptionsPage(Model model) {
        currentUser = MainController.getCurrentUser();
        List<Subscription> userSubscriptionList = currentUser.getSubscriptionList();

        model.addAttribute("locale", controlledView);
        model.addAttribute("userSubscriptionList", userSubscriptionList);

        return "my-subscriptions";
    }

}
