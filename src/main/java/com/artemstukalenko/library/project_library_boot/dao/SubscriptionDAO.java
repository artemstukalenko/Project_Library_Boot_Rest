package com.artemstukalenko.library.project_library_boot.dao;


import com.artemstukalenko.library.project_library_boot.entity.Subscription;

import java.util.List;

public interface SubscriptionDAO {

    public void registerSubscriptionInDB(Subscription subscriptionToRegister);

    public List<Subscription> getAllSubscriptions();

}
