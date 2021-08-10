package com.artemstukalenko.library.project_library_boot.service.implementators;

import com.artemstukalenko.library.project_library_boot.dao.CustomSubscriptionRequestDAO;
import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;
import com.artemstukalenko.library.project_library_boot.service.CustomSubscriptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomSubscriptionRequestServiceImpl
        implements CustomSubscriptionRequestService {

    @Autowired
    CustomSubscriptionRequestDAO customSubscriptionRequestDAO;

    @Override
    public void addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request) {
        customSubscriptionRequestDAO.addCustomSubscriptionRequestToDB(request);
    }

    @Override
    public void deleteCustomSubscriptionRequestFromDB(int id) {
        customSubscriptionRequestDAO.deleteCustomSubscriptionRequestFromDB(id);
    }

    @Override
    public List<CustomSubscriptionRequest> getAllRequests() {
        return customSubscriptionRequestDAO.getAllRequests();
    }

    @Override
    public CustomSubscriptionRequest findRequestById(int id) {
        return customSubscriptionRequestDAO.findRequestById(id);
    }

}
