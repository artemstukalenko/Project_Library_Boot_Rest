package com.artemstukalenko.library.project_library_boot.service.implementators;

import com.artemstukalenko.library.project_library_boot.dao.SubscriptionDAO;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import com.artemstukalenko.library.project_library_boot.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionDAO subscriptionDAO;

    @Override
    public boolean registerSubscriptionInDB(Subscription subscriptionToRegister) {
        return subscriptionDAO.registerSubscriptionInDB(subscriptionToRegister);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionDAO.getAllSubscriptions();
    }

    @Override
    public Subscription findSubscriptionById(int id) {
        return subscriptionDAO.findSubscriptionById(id);
    }

    @Override
    public boolean deleteSubscriptionFromDB(int id) {
        return subscriptionDAO.deleteSubscriptionFromDB(id);
    }

    @Override
    public Subscription findSubscriptionByBookId(int bookId) {
        return subscriptionDAO.findSubscriptionByBookId(bookId);
    }
}
