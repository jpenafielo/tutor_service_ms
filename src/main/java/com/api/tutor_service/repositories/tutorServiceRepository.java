package com.api.tutor_service.repositories;
import com.api.tutor_service.models.tutorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tutorServiceRepository extends JpaRepository<tutorService, Long> {
    
}