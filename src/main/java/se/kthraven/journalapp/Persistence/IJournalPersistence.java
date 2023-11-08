package se.kthraven.journalapp.Persistence;

import se.kthraven.journalapp.Persistence.entities.EncounterDB;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.Collection;

public interface IJournalPersistence {
    public Collection<PersonDB> getAllPatients();
    public Collection<PersonDB> getAllPatientsByDoctor(String doctorId);
    public PersonDB getPerson(String id);
    public PersonDB getDoctor(String id);
    public Collection<EncounterDB> getEncountersByPatient(String patientId);
}
