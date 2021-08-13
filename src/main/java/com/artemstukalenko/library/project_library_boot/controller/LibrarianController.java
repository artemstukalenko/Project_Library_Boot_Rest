package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.service.CustomSubscriptionRequestService;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarian")
public class LibrarianController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    CustomSubscriptionRequestService customSubscriptionRequestService;

    @GetMapping("/getSubscriptionList")
    public List<Subscription> getSubscriptionsListPage(Model model) {
        return subscriptionService.getAllSubscriptions();
    }

    @RequestMapping("/acceptRequest/{requestId}")
    public List<Subscription> acceptRequest(@PathVariable("requestId") int requestId) {
        subscriptionService.registerSubscriptionInDB(
                new Subscription(customSubscriptionRequestService.findRequestById(requestId))
        );

        customSubscriptionRequestService.deleteCustomSubscriptionRequestFromDB(requestId);

        return subscriptionService.getAllSubscriptions();
    }

    @DeleteMapping("/denyRequest/{requestId}")
    public List<Subscription> denyRequest(@PathVariable("requestId") int requestId) {
        customSubscriptionRequestService.deleteCustomSubscriptionRequestFromDB(requestId);

        return subscriptionService.getAllSubscriptions();
    }
}
