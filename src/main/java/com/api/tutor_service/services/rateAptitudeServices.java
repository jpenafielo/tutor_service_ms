package com.api.tutor_service.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.tutor_service.models.rateAptitude;
import com.api.tutor_service.models.tutorService;
import com.api.tutor_service.repositories.RateRepository;
import com.api.tutor_service.repositories.tutorServiceRepository;
import com.api.tutor_service.exceptions.ResourceNotFoundException;


@Service
public class rateAptitudeServices {

    @Autowired
        RateRepository rateRepository;

    @Autowired
    private tutorServiceRepository tutorServiceRepository;

        public rateAptitude createRateAptitude(rateAptitude rateApt) {
            tutorService service = tutorServiceRepository.findById(rateApt.getService().getIdService()) .orElseThrow(() -> new ResourceNotFoundException("Service not found with id " + rateApt.getService().getIdService()));
            rateApt.setService(service);
            return rateRepository.save(rateApt);
        }

        public List<rateAptitude> getAptitudesByService(Long serviceId) {
            return rateRepository.findByServiceIdService(serviceId);
        }

// READ
    public ArrayList<rateAptitude> getRates() {
        return (ArrayList<rateAptitude>) rateRepository.findAll();
    }

    public Optional<rateAptitude> getRatesbyID(Long id) {
        Optional<rateAptitude> result = rateRepository.findById(id);
        return result;
    }

    // DELETE
    public void deleteRates(Long rateId) {
        
        rateAptitude rate = rateRepository.findById(rateId)
        .orElseThrow(() -> new ResourceNotFoundException("Service" + rateId));

        rate.setAptitudeState(false);
        rateRepository.save(rate);
    }

    // UPDATE

    public rateAptitude UpdateRate(Long rateId, rateAptitude rateDetails){

        rateAptitude rate = rateRepository.findById(rateId).get();
        
        if (rateDetails.getIdQualifier() != null){
            rate.setIdQualifier(rateDetails.getIdQualifier());
        }

        if (rateDetails.getService()!=null){
            rate.setService(rateDetails.getService());
        }
        if (rateDetails.getAptitudeName() != null){
            rate.setAptitudeName(rateDetails.getAptitudeName());
        }

        if (rateDetails.getAptitudeRate() != null){
            rate.setAptitudeRate(rateDetails.getAptitudeRate());
        }

        if (rateDetails.getAptitudeState() != null){
            rate.setAptitudeState(rateDetails.getAptitudeState());
        }

        return rateRepository.save(rate);
    
    }

    
  

}

