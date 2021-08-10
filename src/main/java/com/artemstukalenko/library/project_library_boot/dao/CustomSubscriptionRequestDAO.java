package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;

import java.util.List;

public interface CustomSubscriptionRequestDAO {

    public boolean addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request);

    public boolean deleteCustomSubscriptionRequestFromDB(int id);

    public List<CustomSubscriptionRequest> getAllRequests();

    public CustomSubscriptionRequest findRequestById(int id);
}
