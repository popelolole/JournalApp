package se.kthraven.journalapp.Model;

public class Observation {
    private final String id;
    private String observation;
    private final Person patient;

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
