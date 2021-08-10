package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    public boolean registerSubscriptionInDB(Subscription subscriptionToRegister);

    public List<Subscription> getAllSubscriptions();

    public Subscription findSubscriptionById(int id);

    public boolean deleteSubscriptionFromDB(int id);

    public Subscription findSubscriptionByBookId(int id);

}
