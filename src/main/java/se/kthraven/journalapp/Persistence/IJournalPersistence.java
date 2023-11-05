package se.kthraven.journalapp.Persistence;

import se.kthraven.journalapp.Model.records.Encounter;
import se.kthraven.journalapp.Model.records.Person;

import java.util.Collection;

public interface IJournalPersistence {
    public Collection<Person> getAllPatients();
    public Collection<Person> getAllPatientsByDoctor(String doctorId);
    public Person getPatient(String id);
    public Person getDoctor(String id);
    public Collection<Encounter> getEncountersByPatient(String patientId);
}
