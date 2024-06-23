package org.example.tp_j2ee.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultation", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate dateConsultation;
    private String nameDoctor;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name  = "idPatient")
    private Patient patient;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TreatmentSheet> treatmentSheets = new ArrayList<>();

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prescription> prescriptions = new ArrayList<>();


    public Consultation(LocalDate dateConsultation, String nameDoctor, Patient patient) {
        this.dateConsultation = dateConsultation;
        this.nameDoctor = nameDoctor;
        this.patient = patient;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(LocalDate dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<TreatmentSheet> getTreatmentSheets() {
        return treatmentSheets;
    }

    public void setTreatmentSheets(List<TreatmentSheet> treatmentSheets) {
        this.treatmentSheets = treatmentSheets;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void add (Prescription prescription){
        prescriptions.add(prescription);
    }

    public void add (TreatmentSheet treatmentSheet){
        treatmentSheets.add(treatmentSheet);
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateConsultation=" + dateConsultation +
                ", nameDoctor='" + nameDoctor + '\'' +
               ", patient=" + patient +
              //  ", treatmentSheets=" + treatmentSheets + à enlever

             //   ", prescriptions=" + prescriptions + à enlever
                '}';
    }
}
