package se.kthraven.journalapp.Persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Observation")
public class ObservationDB {
    @Id
    private String id;
    private String observation;

    @OneToOne
    @JoinColumn(name = "patientId")
    private PersonDB patient;

    @ManyToOne
    @JoinColumn(name = "encounterId")
    private EncounterDB encounter;

    public ObservationDB(){

    }

    public ObservationDB(String id, String observation, PersonDB patient, EncounterDB encounter) {
        this.id = id;
        this.observation = observation;
        this.patient = patient;
        this.encounter = encounter;
    }

    public String getId() {
        return id;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public PersonDB getPatient() {
        return patient;
    }

    public EncounterDB getEncounter() {
        return encounter;
    }
}
