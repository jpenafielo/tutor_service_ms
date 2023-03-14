package com.api.tutor_service.repositories;
import com.api.tutor_service.models.rateAptitude;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<rateAptitude, Long> {

    List<rateAptitude> findByServiceIdService(Long serviceId);

}