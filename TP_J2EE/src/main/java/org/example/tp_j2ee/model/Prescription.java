package org.example.tp_j2ee.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_medication")
    private String typeMedication;

    @Column(name = "duration_prescription")
    private int durationPrescription;

    @ManyToOne (cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TreatmentSheet> treatmentSheets = new ArrayList<>();

    public Prescription(String typeMedication, int durationPrescription, Consultation consultation) {
        this.typeMedication = typeMedication;
        this.durationPrescription = durationPrescription;
        this.consultation = consultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeMedication() {
        return typeMedication;
    }

    public void setTypeMedication(String typeMedication) {
        this.typeMedication = typeMedication;
    }

    public int getDurationPrescription() {
        return durationPrescription;
    }

    public void setDurationPrescription(int durationPrescription) {
        this.durationPrescription = durationPrescription;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public List<TreatmentSheet> getTreatmentSheets() {
        return treatmentSheets;
    }

    public void setTreatmentSheets(List<TreatmentSheet> treatmentSheets) {
        this.treatmentSheets = treatmentSheets;
    }

    public void add (TreatmentSheet treatmentSheet){
        treatmentSheets.add(treatmentSheet);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", typeMedication='" + typeMedication + '\'' +
                ", durationPrescription=" + durationPrescription +
                ", consultation=" + consultation +
               // ", treatmentSheets=" + treatmentSheets + à enlever
                '}';
    }
}
