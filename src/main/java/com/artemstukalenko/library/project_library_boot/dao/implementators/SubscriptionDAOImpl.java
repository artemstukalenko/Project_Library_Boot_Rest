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
    public boolean registerSubscriptionInDB(Subscription subscriptionToRegister) {
        entityManager.persist(subscriptionToRegister);
        return true;
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return entityManager.createQuery("from Subscription").getResultList();
    }

    @Override
    public Subscription findSubscriptionById(int id) {
        return entityManager.find(Subscription.class, id);
    }

    @Override
    @Transactional
    public boolean deleteSubscriptionFromDB(int id) {
        Query queryForDeletingSubscription = entityManager.createQuery("delete from Subscription " +
                "where subscriptionId =: id");
        queryForDeletingSubscription.setParameter("id", id);

        queryForDeletingSubscription.executeUpdate();
        return true;
    }

    @Override
    public Subscription findSubscriptionByBookId(int bookId) {
        Query queryForFindingSubscriptionByBookId =
                entityManager.createQuery("from Subscription where bookId =: bookId");
        queryForFindingSubscriptionByBookId.setParameter("bookId", bookId);

        return (Subscription) queryForFindingSubscriptionByBookId.getSingleResult();
    }
}
