package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;

import java.util.List;

public interface CustomSubscriptionRequestDAO {

    public void addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request);

    public void deleteCustomSubscriptionRequestFromDB(int id);

    public List<CustomSubscriptionRequest> getAllRequests();

    public CustomSubscriptionRequest findRequestById(int id);
}
