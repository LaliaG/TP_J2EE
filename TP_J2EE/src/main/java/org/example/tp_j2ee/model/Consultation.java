package org.example.tp_j2ee.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultation", nullable = false)
    private Long id;
    private LocalDate dateConsultation;
    private String nameDoctor;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "careSheet_id", referencedColumnName = "id_careSheet")
    private CareSheet careSheet;
    @OneToOne
    @JoinColumn(name = "prescription_id", referencedColumnName = "id_prescription")
    private Prescription prescription;

    public Consultation(LocalDate dateConsultation, String nameDoctor, Patient patient, CareSheet careSheet, Prescription prescription) {
        this.dateConsultation = dateConsultation;
        this.nameDoctor = nameDoctor;
        this.patient = patient;
        this.careSheet = careSheet;
        this.prescription = prescription;
    }
}
