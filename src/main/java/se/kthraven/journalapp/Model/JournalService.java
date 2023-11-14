package se.kthraven.journalapp.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import se.kthraven.journalapp.Model.classes.Encounter;
import se.kthraven.journalapp.Model.classes.Person;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Persistence.IJournalPersistence;
import se.kthraven.journalapp.Persistence.entities.EncounterDB;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.ArrayList;
import java.util.Collection;

import static se.kthraven.journalapp.Model.CustomUserDetailsService.getCurrentUserPerson;

@Component
public class JournalService implements IJournalService{
    @Autowired
    private IJournalPersistence persistence;

    public Collection<Person> getAllPatients(){
        //
        return null;
    }

    public Person getPerson(String id){
        checkAuthorityDoctorOrSamePatient(id);
        PersonDB personDb = persistence.getPerson(id);
        Person person = Person.from(personDb);
        return person;
    }

    public void createPatient(Person patient){
        //
    }

    public void updatePatient(Person patient){
        //
    }

    public Collection<Encounter> getEncountersByPatient(String patientId){
        checkAuthorityDoctorOrSamePatient(patientId);
        Collection<EncounterDB> encounterDbs = persistence.getEncountersByPatient(patientId);
        ArrayList<Encounter> encounters = new ArrayList<>();
        for(EncounterDB encounterDb : encounterDbs){
            encounters.add(Encounter.from(encounterDb));
        }
        return encounters;
    }

    private void checkAuthorityDoctorOrSamePatient(String patientId){
        Person loggedIn = getCurrentUserPerson();
        if(!loggedIn.getRole().equals(Role.DOCTOR) && !loggedIn.getId().equals(patientId))
            throw new AccessDeniedException("No authority to access data");
    }
}
