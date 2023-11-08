package se.kthraven.journalapp.Persistence;

import jakarta.persistence.EntityManager;
import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Model.enums.Severity;
import se.kthraven.journalapp.Model.records.Encounter;
import se.kthraven.journalapp.Model.records.Person;
import se.kthraven.journalapp.Persistence.entities.ConditionDB;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.Collection;
import java.sql.Date;
import java.util.UUID;

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

        EntityManager entityManager = DBManager.getEntityManager();

        System.out.println(entityManager.find(PersonDB.class, "hej123"));
        entityManager.getTransaction().begin();

        PersonDB person = new PersonDB();

        person.setId(UUID.randomUUID().toString());
        person.setName("Pelle");
        person.setGender(Gender.MALE);
        person.setDob(Date.valueOf("2002-11-21"));
        person.setRole(Role.PATIENT);

        entityManager.persist(person);

        entityManager.getTransaction().commit();
        entityManager.close();
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
