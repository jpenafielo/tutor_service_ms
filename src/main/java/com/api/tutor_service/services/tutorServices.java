package com.api.tutor_service.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.tutor_service.Dao.TutorServiceDao;
import com.api.tutor_service.models.tutorService;



@Service
public class tutorServices {
    

    @Autowired
        TutorServiceDao tutorRepository;



    public tutorService insertService(tutorService tutor){
        return this.tutorRepository.save(tutor);
    }


    // READ
    public ArrayList<tutorService> getServices() {
        return (ArrayList<tutorService>) this.tutorRepository.getAllServicesFromSlave() ;
        
    }

    public Optional<tutorService> getServicebyID(Long id) {
        Optional<tutorService> result = this.tutorRepository.findById(id);
        return result;
    }

    // DELETE
    public ResponseEntity<Object> deleteService(Long ServiceId) {
           
        tutorRepository.deleteById(ServiceId);


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

