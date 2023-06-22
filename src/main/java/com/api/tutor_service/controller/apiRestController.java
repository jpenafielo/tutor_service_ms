package com.api.tutor_service.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.tutor_service.services.rateAptitudeServices;
import com.api.tutor_service.services.tutorServices;
import com.api.tutor_service.models.rateAptitude;
import com.api.tutor_service.models.tutorService;


@RestController
public class apiRestController {

        @Autowired
        rateAptitudeServices rateService;



        //RateAptitude Controller
        
        //Create Rate
        @RequestMapping(value="/rates", method = RequestMethod.POST)      
        public rateAptitude createRateAptitude(@RequestBody rateAptitude rateApt) {
            try{
                return rateService.createRateAptitude(rateApt);
            } catch (Exception e){
                return null;
            }
        }

        //Get all rates
        @RequestMapping(value="/rates", method = RequestMethod.GET)
        public ArrayList<rateAptitude> getRatesController() {        
            return this.rateService.getRates();
        }

        //Get rates by id
        @RequestMapping(value="/rates/{RateId}", method=RequestMethod.GET)
        public Optional<rateAptitude> getRateById(@PathVariable(value = "RateId") Long id) {
            return rateService.getRatesbyID(id);
        }

        //Get Rates by service id
        @RequestMapping(value="/rates/services/{serviceId}", method=RequestMethod.GET)
        public List<rateAptitude> getServicesRatesById(@PathVariable(value = "serviceId") Long serviceId) {
            return rateService.getAptitudesByService(serviceId);
        }

        //Delete rate
        @RequestMapping(value="/rates/{RateId}", method=RequestMethod.DELETE)
        public ResponseEntity<String> deleteRatesController(@PathVariable(value = "RateId") Long id) {
            try {
                rateService.deleteRates(id);
                return new ResponseEntity<>("Operation success", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>( "Something wrong happened...", HttpStatus.BAD_REQUEST);
            }
        }

        //Update rate
        @RequestMapping(value="/rates/{RateId}", method = RequestMethod.PUT)
        public rateAptitude updateRate(@PathVariable(value="RateId") Long id, @RequestBody rateAptitude rate) throws Exception {

            try{
                return rateService.UpdateRate(id, rate);
            } catch (Exception e){
                return null;
            }

        }

        //TutorService controller

        @Autowired
        tutorServices tutorService;

        //CREATE SERVICE
        @PostMapping("/services")
        public tutorService saveService(@RequestBody tutorService service) {
            try{
                return tutorService.insertService(service);
            } catch (Exception e){
                return null;
            }
                
        }

        //CONSULTAR SERVICIOS
        @GetMapping("/services")
        public ArrayList<tutorService> getServicesController() {        
            return this.tutorService.getServices();
        }
        
        //CONSULTAR SERVICIOS POR ID
        @GetMapping("/services/{serviceId}")
        public Optional<tutorService> getServiceById(@PathVariable(value = "serviceId") Long id) {
            return tutorService.getServicebyID(id);
        }
         
        //ELIMINAR SERVICIOS (ACTUALIZARLOS A FALSE)
        @DeleteMapping("/services/{serviceId}")
        public ResponseEntity<String> deleteServiceController(@PathVariable(value = "serviceId") Long id) {
            
            try {
                tutorService.deleteService(id);
                return new ResponseEntity<>("Operation success", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>( "Something wrong happened...", HttpStatus.BAD_REQUEST);
            }

        }

        //ACTUALIZAR SERVICIOS
        @PutMapping("/services/{ServiceId}")
        public tutorService updateService(@PathVariable(value="ServiceId") Long id, @RequestBody tutorService tutor) throws Exception {

            try {
               
                return  tutorService.UpdateService(id,tutor);
            } catch (Exception e) {

                return null;

            }

        }

        
}

