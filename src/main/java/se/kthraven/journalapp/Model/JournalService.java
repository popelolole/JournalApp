package se.kthraven.journalapp.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.kthraven.journalapp.Model.records.Encounter;
import se.kthraven.journalapp.Model.records.Person;
import se.kthraven.journalapp.Persistence.IJournalPersistence;
import se.kthraven.journalapp.Persistence.JournalPersistence;

import java.util.Collection;

@Component
public class JournalService implements IJournalService{
    @Autowired
    private IJournalPersistence persistence;

    public Collection<Person> getAllPatients(){
        //
        return null;
    }

    public Person getPatient(String id){
        return persistence.getPatient(id);
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
