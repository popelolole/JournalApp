package se.kthraven.journalapp.Model.classes;

import se.kthraven.journalapp.Persistence.entities.ObservationDB;

public class Observation {
    private String id;
    private String observation;
    private Person patient;

    public static Observation from(ObservationDB observationDb){
        if(observationDb == null)
            return null;
        Observation observation = new Observation();
        observation.id = observationDb.getId();
        observation.observation = observationDb.getObservation();
        observation.patient = Person.from(observationDb.getPatient());
        return observation;
    }

    public Observation(){

    }

    public Observation(String id, String observation, Person patient) {
        this.id = id;
        this.observation = observation;
        this.patient = patient;
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

    public Person getPatient() {
        return patient;
    }
}
