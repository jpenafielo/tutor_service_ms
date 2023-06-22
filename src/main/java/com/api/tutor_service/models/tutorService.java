package com.api.tutor_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "services")
@Data
public class tutorService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservice")
    private Long idService;

    @Column(name = "idprofile")
    private String idProfile;

    @Column(name = "description")
    private String description;

    @Column(name = "servicestate")
    private Boolean serviceState;
}
