package com.artemstukalenko.library.project_library_boot.service.implementators;

import com.artemstukalenko.library.project_library_boot.dao.CustomSubscriptionRequestDAO;
import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;
import com.artemstukalenko.library.project_library_boot.service.CustomSubscriptionRequestService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomSubscriptionRequestServiceImpl
        implements CustomSubscriptionRequestService {

    CustomSubscriptionRequestDAO customSubscriptionRequestDAO;

    @Override
    @Transactional
    public void addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request) {
        customSubscriptionRequestDAO.addCustomSubscriptionRequestToDB(request);
    }

    @Override
    @Transactional
    public void deleteCustomSubscriptionRequestFromDB(int id) {
        customSubscriptionRequestDAO.deleteCustomSubscriptionRequestFromDB(id);
    }

}
