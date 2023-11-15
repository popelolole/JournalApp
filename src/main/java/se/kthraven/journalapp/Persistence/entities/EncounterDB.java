package se.kthraven.journalapp.Persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "encounter")
public class EncounterDB {
    @Id
    private String id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private PersonDB patient;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "doctor_id")
    private PersonDB doctor;
    private Date date;
    private String location;

    @OneToMany(mappedBy = "encounter", fetch = FetchType.EAGER)
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

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "EncounterDB{" +
                "id='" + id + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", observations=" + observations +
                '}';
    }
}
