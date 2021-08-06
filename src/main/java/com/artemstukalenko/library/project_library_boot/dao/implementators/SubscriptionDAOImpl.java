package com.artemstukalenko.library.project_library_boot.dao.implementators;

import com.artemstukalenko.library.project_library_boot.dao.SubscriptionDAO;
import com.artemstukalenko.library.project_library_boot.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SubscriptionDAOImpl implements SubscriptionDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void registerSubscriptionInDB(Subscription subscriptionToRegister) {
        entityManager.persist(subscriptionToRegister);
    }

    @Override
    @Transactional
    public List<Subscription> getAllSubscriptions() {
        return entityManager.createQuery("from Subscription").getResultList();
    }

    @Override
    @Transactional
    public Subscription findSubscriptionById(int id) {
        return entityManager.find(Subscription.class, id);
    }

    @Override
    @Transactional
    public void deleteSubscriptionFromDB(int id) {
        Query queryForDeletingSubscription = entityManager.createQuery("delete from Subscription " +
                "where subscriptionId =: id");
        queryForDeletingSubscription.setParameter("id", id);

        queryForDeletingSubscription.executeUpdate();
    }
}
