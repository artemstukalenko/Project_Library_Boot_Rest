package com.artemstukalenko.library.project_library_boot.dao.implementators;

import com.artemstukalenko.library.project_library_boot.dao.CustomSubscriptionRequestDAO;
import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomSubscriptionRequestDAOImpl implements CustomSubscriptionRequestDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request) {
        entityManager.persist(request);
    }

    @Override
    @Transactional
    public void deleteCustomSubscriptionRequestFromDB(int id) {
        Query queryForDeletingCustomSubscriptionRequest =
                entityManager.createQuery("delete from CustomSubscriptionRequest " +
                        "where customSubscriptionId =: id");

        queryForDeletingCustomSubscriptionRequest.setParameter("id", id);

        queryForDeletingCustomSubscriptionRequest.executeUpdate();
    }

    @Override
    @Transactional
    public List<CustomSubscriptionRequest> getAllRequests() {
        Query queryForGettingAllRequests = entityManager.createQuery("from CustomSubscriptionRequest");

        return queryForGettingAllRequests.getResultList();
    }

    @Override
    @Transactional
    public CustomSubscriptionRequest findRequestById(int id) {
        return entityManager.find(CustomSubscriptionRequest.class, id);
    }
}
