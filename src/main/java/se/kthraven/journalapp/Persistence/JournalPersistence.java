package se.kthraven.journalapp.Persistence;

import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Model.records.Encounter;
import se.kthraven.journalapp.Model.records.Person;

import java.time.Month;
import java.util.Collection;
import java.util.Date;

public class JournalPersistence implements IJournalPersistence{

    @Override
    public Collection<Person> getAllPatients() {
        return null;
    }

    @Override
    public Collection<Person> getAllPatientsByDoctor(String doctorId) {
        return null;
    }

    @Override
    public Person getPatient(String id) {
        Person patient = new Person(id, "Pelle Berggren", Gender.MALE,
                new Date(2002, 11, 21), Role.PATIENT);
        return patient;
    }

    @Override
    public Person getDoctor(String id) {
        return null;
    }

    @Override
    public Collection<Encounter> getEncountersByPatient(String patientId) {
        return null;
    }
}
