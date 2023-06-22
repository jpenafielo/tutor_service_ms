package com.api.tutor_service.repositories;

import com.api.tutor_service.annotation.ReadOnlyRepository;
import com.api.tutor_service.models.tutorService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ReadOnlyRepository
@Qualifier("slaveDataSource") 
public interface tutorReadOnlyRepository extends JpaRepository<tutorService, Long> {
}