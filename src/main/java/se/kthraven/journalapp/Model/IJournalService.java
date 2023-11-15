package se.kthraven.journalapp.Model;

import se.kthraven.journalapp.Model.classes.*;

import java.util.Collection;

public interface IJournalService {
    Collection<Person> getAllPatients();
    Patient getPatient(String id);
    Doctor getDoctor(String id);
    void createPatient(Patient patient);
    void updatePatient(Person patient);
    Collection<Encounter> getEncountersByPatient(String patientId);
    Encounter getEncounter(String id);
    void createEncounter(Encounter encounter);
    void createObservation(Observation observation, String encounterId);
}
