package se.kthraven.journalapp.Model;

import se.kthraven.journalapp.Model.classes.Doctor;
import se.kthraven.journalapp.Model.classes.Encounter;
import se.kthraven.journalapp.Model.classes.Patient;
import se.kthraven.journalapp.Model.classes.Person;

import java.util.Collection;

public interface IJournalService {
    Collection<Person> getAllPatients();
    Patient getPatient(String id);
    Doctor getDoctor(String id);
    void createPatient(Patient patient);
    void updatePatient(Person patient);
    Collection<Encounter> getEncountersByPatient(String patientId);
}
