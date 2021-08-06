package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    public void registerSubscriptionInDB(Subscription subscriptionToRegister);

    public List<Subscription> getAllSubscriptions();

}
