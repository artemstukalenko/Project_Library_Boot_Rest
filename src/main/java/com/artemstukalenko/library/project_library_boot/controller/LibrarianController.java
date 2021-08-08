package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.service.CustomSubscriptionRequestService;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LibrarianController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    FirstView controlledView;

    @Autowired
    CustomSubscriptionRequestService customSubscriptionRequestService;

    @RequestMapping("/asLibrarian")
    public String getLibrarianEntryPage(Model model) {
        model.addAttribute("locale", controlledView);
        List<Subscription> allSubscriptions = subscriptionService.getAllSubscriptions();
        model.addAttribute("allSubscriptions", allSubscriptions);
        model.addAttribute("allRequests", customSubscriptionRequestService.getAllRequests());
        return "subscriptions-page";
    }

}
