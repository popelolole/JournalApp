package se.kthraven.journalapp.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.kthraven.journalapp.Model.classes.Encounter;
import se.kthraven.journalapp.Model.classes.Person;
import se.kthraven.journalapp.Persistence.IJournalPersistence;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.Collection;

@Component
public class JournalService implements IJournalService{
    @Autowired
    private IJournalPersistence persistence;

    public Collection<Person> getAllPatients(){
        //
        return null;
    }

    public Person getPerson(String id){
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
        //
        return null;
    }
}
