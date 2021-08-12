package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.CustomSubscriptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomSubscriptionRequestRepository extends JpaRepository<CustomSubscriptionRequest, Integer> {
}
