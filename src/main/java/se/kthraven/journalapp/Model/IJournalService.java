package se.kthraven.journalapp.Model;

import se.kthraven.journalapp.Model.classes.Encounter;
import se.kthraven.journalapp.Model.classes.Person;

import java.util.Collection;

public interface IJournalService {
    Collection<Person> getAllPatients();
    Person getPerson(String id);
    void createPatient(Person patient);
    void updatePatient(Person patient);
    Collection<Encounter> getEncountersByPatient(String patientId);
}
