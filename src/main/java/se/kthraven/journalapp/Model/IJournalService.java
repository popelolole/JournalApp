package se.kthraven.journalapp.Model;

import se.kthraven.journalapp.Model.records.Encounter;
import se.kthraven.journalapp.Model.records.Person;

import java.util.Collection;

public interface IJournalService {
    Collection<Person> getAllPatients();
    Person getPatient(String id);
    void createPatient(Person patient);
    void updatePatient(Person patient);
    Collection<Encounter> getEncountersByPatient(String patientId);
}
