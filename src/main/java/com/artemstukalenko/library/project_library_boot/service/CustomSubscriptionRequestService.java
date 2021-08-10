package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;

import java.util.List;

public interface CustomSubscriptionRequestService {

    public boolean addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request);

    public boolean deleteCustomSubscriptionRequestFromDB(int id);

    public List<CustomSubscriptionRequest> getAllRequests();

    public CustomSubscriptionRequest findRequestById(int id);

}
