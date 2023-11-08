package se.kthraven.journalapp.Persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Encounter")
public class EncounterDB {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "patientId")
    private PersonDB patient;

    @OneToOne
    @JoinColumn(name = "doctorId")
    private PersonDB doctor;
    private Date date;
    private String location;

    @OneToMany
    private Collection<ObservationDB> observations = new ArrayList<>();

    public EncounterDB(){

    }

    public EncounterDB(String id, PersonDB patient, PersonDB doctor, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public EncounterDB(String id, PersonDB patient, PersonDB doctor, Date date, String location) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.location = location;
    }

    public EncounterDB(String id, PersonDB patient, PersonDB doctor, Date date, String location, Collection<ObservationDB> observations) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.location = location;
        this.observations = observations;
    }

    public String getId() {
        return id;
    }

    public PersonDB getPatient() {
        return patient;
    }

    public PersonDB getDoctor() {
        return doctor;
    }

    public void setDoctor(PersonDB doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Collection<ObservationDB> getObservations() {
        return observations;
    }

    public void setObservations(Collection<ObservationDB> observations) {
        this.observations = observations;
    }

    public void addObservation(ObservationDB observation){
        this.observations.add(observation);
    }
}
