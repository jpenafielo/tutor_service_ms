package com.api.tutor_service.repositories;
import com.api.tutor_service.models.tutorService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tutorServiceRepository extends JpaRepository<tutorService, Long> {
    
}