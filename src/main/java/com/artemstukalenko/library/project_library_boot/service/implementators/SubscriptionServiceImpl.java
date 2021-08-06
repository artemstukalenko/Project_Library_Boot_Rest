package com.artemstukalenko.library.project_library_boot.service.implementators;

import com.artemstukalenko.library.project_library_boot.dao.SubscriptionDAO;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionDAO subscriptionDAO;

    @Override
    @Transactional
    public void registerSubscriptionInDB(Subscription subscriptionToRegister) {
        subscriptionDAO.registerSubscriptionInDB(subscriptionToRegister);
    }
}
