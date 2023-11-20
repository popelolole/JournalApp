package se.kthraven.journalapp.Persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Model.enums.Severity;
import se.kthraven.journalapp.Persistence.entities.*;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.UUID;

@Component
public class JournalPersistence implements IJournalPersistence {
    @Override
    public PersonDB getPerson(String id) {
        EntityManager entityManager = DBManager.getEntityManager();

        PersonDB person = entityManager.find(PersonDB.class, id);

        entityManager.close();
        return person;
    }

    @Override
    public Collection<EncounterDB> getEncountersByPatient(String patientId) {
        EntityManager entityManager = DBManager.getEntityManager();

        Collection<EncounterDB> encounters =
                entityManager.createQuery("SELECT e FROM EncounterDB e WHERE e.patient.id = :pId", EncounterDB.class)
                                .setParameter("pId", patientId)
                                .getResultList();

        entityManager.close();
        return encounters;
    }

    @Override
    public void createPerson(PersonDB person){
        EntityManager em = DBManager.getEntityManager();

        person.setId(UUID.randomUUID().toString());

        if(person.getCondition() != null)
            person.getCondition().setId(UUID.randomUUID().toString());

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public EncounterDB getEncounter(String id) {
        EntityManager em = DBManager.getEntityManager();

        EncounterDB encounter = em.find(EncounterDB.class, id);

        em.close();
        return encounter;
    }

    @Override
    public void createEncounter(EncounterDB encounter) {
        EntityManager em = DBManager.getEntityManager();

        encounter.setId(UUID.randomUUID().toString());

        if(!encounter.getObservations().isEmpty()) {
            for(ObservationDB observation : encounter.getObservations()){
                observation.setId(UUID.randomUUID().toString());
            }
        }

        em.getTransaction().begin();
        em.persist(encounter);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void createObservation(ObservationDB observation) {
        EntityManager em = DBManager.getEntityManager();

        observation.setId(UUID.randomUUID().toString());

        em.getTransaction().begin();
        em.persist(observation);
        em.getTransaction().commit();
        em.close();
    }
}
