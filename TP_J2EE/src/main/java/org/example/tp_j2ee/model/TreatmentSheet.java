package org.example.tp_j2ee.model;

import jakarta.persistence.*;

@Entity
public class TreatmentSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_treatmentSheet", nullable = false)
    private Long id;
    @Column(name = "type_treatment")
    private String typeTreatment;
    @Column(name = "duration_treatment")
    private int durationTreatment;

    @ManyToOne (cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @ManyToOne (cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public TreatmentSheet() {
    }

    public TreatmentSheet(String typeTreatment, int durationTreatment, Consultation consultation, Prescription prescription) {
        this.typeTreatment = typeTreatment;
        this.durationTreatment = durationTreatment;
        this.consultation = consultation;
        this.prescription = prescription ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeTreatment() {
        return typeTreatment;
    }

    public void setTypeTreatment(String typeTreatment) {
        this.typeTreatment = typeTreatment;
    }

    public int getDurationTreatment() {
        return durationTreatment;
    }

    public void setDurationTreatment(int durationTreatment) {
        this.durationTreatment = durationTreatment;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "TreatmentSheet{" +
                "id=" + id +
                ", typeTreatment='" + typeTreatment + '\'' +
                ", durationTreatment=" + durationTreatment +
                ", consultation=" + consultation +
                ", prescription=" + prescription +
                '}';
    }
}
