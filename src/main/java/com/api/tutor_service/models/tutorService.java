package com.api.tutor_service.models;
import jakarta.persistence.*;

@Entity
@Table (name="services")
public class tutorService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idservice")
        private Long idService;

    @Column(name="idprofile")
    private String idProfile;

    @Column (name="description")
    private String description;

    @Column (name="servicestate")
    private Boolean serviceState;


    //Getters

    public Long getIdService() {
        return idService;
    }

    public String getIdProfile() {
        return idProfile;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getServiceState() {
        return serviceState;

        
    }

    //Setters


    public void setIdProfile(String idProfile) {
        this.idProfile = idProfile;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setServiceState(Boolean serviceState) {
        this.serviceState = serviceState;
    }

    
}
