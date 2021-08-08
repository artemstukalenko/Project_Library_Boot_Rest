package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;

public interface CustomSubscriptionRequestDAO {

    public void addCustomSubscriptionRequestToDB(CustomSubscriptionRequest request);

    public void deleteCustomSubscriptionRequestFromDB(int id);

}
