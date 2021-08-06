package com.artemstukalenko.library.project_library_boot.dao.implementators;

import com.artemstukalenko.library.project_library_boot.dao.SubscriptionDAO;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class SubscriptionDAOImpl implements SubscriptionDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void registerSubscriptionInDB(Subscription subscriptionToRegister) {
        entityManager.persist(subscriptionToRegister);
    }
}
