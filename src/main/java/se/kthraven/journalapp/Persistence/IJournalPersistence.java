package se.kthraven.journalapp.Persistence;

import se.kthraven.journalapp.Persistence.entities.EncounterDB;
import se.kthraven.journalapp.Persistence.entities.ObservationDB;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.Collection;

public interface IJournalPersistence {
     PersonDB getPerson(String id);
     void createPerson(PersonDB person);
     Collection<EncounterDB> getEncountersByPatient(String patientId);
     EncounterDB getEncounter(String id);
     void createEncounter(EncounterDB encounter);
     void createObservation(ObservationDB observation);
     void seedUsers();
}
