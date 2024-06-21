package org.example.tp_j2ee.model;

import jakarta.persistence.*;

public class CareSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_care", nullable = false)
    private Long id;
    @Column(name = "type_care")
    private String typeCare;
    @Column(name = "duration_care")
    private int durationCare;
    @OneToOne(mappedBy = "care")
    private Consultation consultation;
}
