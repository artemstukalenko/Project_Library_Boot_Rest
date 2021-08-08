package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;

public interface CustomSubscriptionRequestService {

    public void addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request);

    public void deleteCustomSubscriptionRequestFromDB(int id);

}
