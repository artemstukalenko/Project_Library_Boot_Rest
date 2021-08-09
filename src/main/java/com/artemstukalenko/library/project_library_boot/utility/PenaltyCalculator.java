package com.artemstukalenko.library.project_library_boot.utility;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.service.implementators.UserServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class PenaltyCalculator {

    public int calculateUsersPenalty(User user) {

        return (int)(user.getSubscriptionList().stream()
                .filter(subscription -> {return subscription.getExpired() && !subscription.getFined();})
                .peek(subscription -> {subscription.setFined(true);})
                .count() * 10);
    }

}
