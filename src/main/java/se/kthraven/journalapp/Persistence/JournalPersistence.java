package se.kthraven.journalapp.Persistence;

import jakarta.persistence.EntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Model.enums.Severity;
import se.kthraven.journalapp.Persistence.entities.*;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.UUID;

public class JournalPersistence implements IJournalPersistence {

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
        EntityManager entityManager = DBManager.getEntityManager();

        Collection<EncounterDB> encounters =
                entityManager.createQuery("SELECT e FROM EncounterDB e WHERE e.patient.id = :pId", EncounterDB.class)
                                .setParameter("pId", patientId)
                                .getResultList();

        for(EncounterDB encounter : encounters){
            System.out.println(encounter.toString());
        }

        entityManager.close();
        return encounters;
    }

    public static void seedData(){
        EntityManager em = DBManager.getEntityManager();

        PersonDB patient = new PersonDB(UUID.randomUUID().toString(), "Pelle", Gender.MALE,
                new Date(2002, 11, 21), Role.PATIENT);
        PersonDB doctor = new PersonDB(UUID.randomUUID().toString(), "Elias", Gender.MALE,
                new Date(2002, 01, 27), Role.DOCTOR);

        patient.setDoctor(doctor);

        EncounterDB encounter = new EncounterDB(UUID.randomUUID().toString(), patient, doctor,
                new Date(2023, 11, 11), "Huddinge Sjukhus");

        ObservationDB observation1 = new ObservationDB(UUID.randomUUID().toString(),
                "He just seems pretty cool to me", patient, encounter);
        ObservationDB observation2 = new ObservationDB(UUID.randomUUID().toString(),
                "He is a shen main", patient, encounter);
        Collection<ObservationDB> observations = new ArrayList<>();
        observations.add(observation1);
        observations.add(observation2);
        encounter.setObservations(observations);

        ConditionDB condition = new ConditionDB(UUID.randomUUID().toString(), "Being cool",
                Severity.EXTREME, new Date(2023, 11, 12));
        patient.setCondition(condition);



        UserDB user1 = new UserDB(UUID.randomUUID().toString(), "pellebe",
                new BCryptPasswordEncoder().encode("password"), Role.PATIENT, patient);
        UserDB user2 = new UserDB(UUID.randomUUID().toString(), "elionbio",
                new BCryptPasswordEncoder().encode("password"), Role.DOCTOR, doctor);

        em.getTransaction().begin();

        em.persist(patient);
        em.persist(doctor);
        em.persist(encounter);
        em.persist(observation1);
        em.persist(observation2);
        em.persist(user1);
        em.persist(user2);

        em.getTransaction().commit();
    }

    public static void main(String[] args){
        seedData();
    }
}
