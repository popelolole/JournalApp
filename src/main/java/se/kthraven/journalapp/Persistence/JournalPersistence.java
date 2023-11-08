package se.kthraven.journalapp.Persistence;

import jakarta.persistence.EntityManager;
import se.kthraven.journalapp.Persistence.entities.EncounterDB;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.Collection;
import java.sql.Date;
import java.util.UUID;

public class JournalPersistence implements IJournalPersistence{

    @Override
    public Collection<PersonDB> getAllPatients() {
        return null;
    }

    @Override
    public Collection<PersonDB> getAllPatientsByDoctor(String doctorId) {
        return null;
    }

    @Override
    public PersonDB getPerson(String id) {
        EntityManager entityManager = DBManager.getEntityManager();

        PersonDB person = entityManager.find(PersonDB.class, id);

        entityManager.close();
        return person;
    }

    @Override
    public PersonDB getDoctor(String id) {
        return null;
    }

    @Override
    public Collection<EncounterDB> getEncountersByPatient(String patientId) {
        return null;
    }
}
