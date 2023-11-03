package se.kthraven.journalapp.Model.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Encounter {
    private final String id;
    private final Person patient;
    private Person doctor;
    private Date date;
    private String location;
    private Collection<Observation> observations = new ArrayList<>();

    public Encounter(String id, Person patient, Person doctor, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Encounter(String id, Person patient, Person doctor, Date date, String location) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.location = location;
    }

    public Encounter(String id, Person patient, Person doctor, Date date, String location, Collection<Observation> observations) {
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

    public Person getPatient() {
        return patient;
    }

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
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

    public Collection<Observation> getObservations() {
        return observations;
    }

    public void setObservations(Collection<Observation> observations) {
        this.observations = observations;
    }

    public void addObservation(Observation observation){
        this.observations.add(observation);
    }
}
