package com.artemstukalenko.library.project_library_boot.dao;


import com.artemstukalenko.library.project_library_boot.entity.Subscription;

public interface SubscriptionDAO {

    public void registerSubscriptionInDB(Subscription subscriptionToRegister);
}
