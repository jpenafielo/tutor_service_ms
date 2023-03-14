package com.api.tutor_service.models;
import jakarta.persistence.*;

@Entity
@Table (name="aptitude")
public class rateAptitude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idrate")
        private Long idRate;

    @ManyToOne
    @JoinColumn(name="idservice")
    private tutorService service;

    @Column(name="idqualifier")
    private Long idQualifier;
    
    @Column(name="aptitudename")
    private String aptitudeName;

    @Column(name="aptituderate")
    private Integer aptitudeRate;

    @Column(name="aptitudestate")
    private Boolean aptitudeState;


    //Getters

    public Long getIdRate() {
        return idRate;
    }

    public tutorService getService() {
        return service;
    }

    public Long getIdQualifier() {
        return idQualifier;
    }

    public String getAptitudeName() {
        return aptitudeName;
    }

    public Integer getAptitudeRate() {
        return aptitudeRate;
    }

    public Boolean getAptitudeState() {
        return aptitudeState;

        
    }

    //Setters

    public void setIdRate(Long idRate) {
       this.idRate = idRate;
    }

    public void setService(tutorService service) {
        this.service = service;
    }

    public void setIdQualifier(Long idQualifier) {
        this.idQualifier = idQualifier;
    }

    public void setAptitudeName(String name) {
        this.aptitudeName = name;
    }

    public void setAptitudeRate(Integer rate) {
        this.aptitudeRate = rate;
    }

    public void setAptitudeState(Boolean state) {
        this.aptitudeState = state;
    }
    
}
