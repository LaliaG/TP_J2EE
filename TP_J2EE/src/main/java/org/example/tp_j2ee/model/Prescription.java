package org.example.tp_j2ee.model;

public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_medicament")
    private String typeMedicament;

    @Column(name = "duree")
    private int duree;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}
