package com.api.tutor_service.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.tutor_service.exceptions.ResourceNotFoundException;
import com.api.tutor_service.models.rateAptitude;
import com.api.tutor_service.models.tutorService;
import com.api.tutor_service.repositories.RateRepository;
import com.api.tutor_service.repositories.tutorServiceRepository;

@Service
public class tutorServices {

    @Autowired
        tutorServiceRepository tutorRepository;

    @Autowired
        RateRepository rateRepository;

    public tutorService insertService(tutorService tutor){
        return this.tutorRepository.save(tutor);
    }


    // READ
    public ArrayList<tutorService> getServices() {
        return (ArrayList<tutorService>) this.tutorRepository.findAll();
    }

    public Optional<tutorService> getServicebyID(Long id) {
        Optional<tutorService> result = this.tutorRepository.findById(id);
        return result;
    }

    // DELETE
    public ResponseEntity<Object> deleteService(Long ServiceId) {
           
        tutorService service = tutorRepository.findById(ServiceId)
        .orElseThrow(() -> new ResourceNotFoundException("Service" + ServiceId));

        List<rateAptitude> aptitudes = rateRepository.findByServiceIdService(ServiceId);

        for (rateAptitude aptitude : aptitudes) {
        aptitude.setAptitudeState(false);
        }

        rateRepository.saveAll(aptitudes);

        service.setServiceState(false);

        tutorRepository.save(service);

        return ResponseEntity.ok().build();
    }

    // UPDATE

    public tutorService UpdateService(Long serviceId, tutorService tutorDetails){

        tutorService tutor = tutorRepository.findById(serviceId).get();

        if (tutorDetails.getIdProfile() != null){
            tutor.setIdProfile(tutorDetails.getIdProfile());
        }
        
        if (tutorDetails.getDescription() != null){
            tutor.setDescription(tutorDetails.getDescription());
        }
            
            
        if (tutorDetails.getServiceState() != null){
            tutor.setServiceState(tutorDetails.getServiceState());
        }
            
        
        return tutorRepository.save(tutor);

    
    }

    
  

}

