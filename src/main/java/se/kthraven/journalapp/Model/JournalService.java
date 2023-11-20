package se.kthraven.journalapp.Model;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import se.kthraven.journalapp.Model.classes.*;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Persistence.IJournalPersistence;
import se.kthraven.journalapp.Persistence.entities.EncounterDB;
import se.kthraven.journalapp.Persistence.entities.ObservationDB;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.ArrayList;
import java.util.Collection;

import static se.kthraven.journalapp.Model.CustomUserDetailsService.getCurrentUserPerson;

@Component
public class JournalService implements IJournalService{
    @Autowired
    private IJournalPersistence persistence;

    @Override
    public Patient getPatient(String id){
        checkAuthorityDoctorOrSamePatient(id);
        PersonDB patientDb = persistence.getPerson(id);

        if(patientDb == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(!patientDb.getRole().equals(Role.PATIENT))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Patient patient = Patient.from(patientDb);
        return patient;
    }

    @Override
    public Doctor getDoctor(String id){
        checkAuthorityDoctorOrOther();
        PersonDB doctorDb = persistence.getPerson(id);
        if(doctorDb == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(!doctorDb.getRole().equals(Role.DOCTOR))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Doctor doctor = Doctor.from(doctorDb);
        return doctor;
    }

    @Override
    public void createPatient(Patient patient) {
        checkAuthorityDoctorOrOther();

        if(!patient.getRole().equals(Role.PATIENT))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        if(patient.getDoctor() != null) {
            PersonDB existingDoctor = persistence.getPerson(patient.getDoctor().getId());

            if(existingDoctor == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            if(!existingDoctor.getRole().equals(Role.DOCTOR))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        PersonDB personDb = patient.toPersonDB();
        persistence.createPerson(personDb);
    }

    @Override
    public Collection<Encounter> getEncountersByPatient(String patientId){
        checkAuthorityDoctorOrSamePatient(patientId);
        Collection<EncounterDB> encounterDbs = persistence.getEncountersByPatient(patientId);
        ArrayList<Encounter> encounters = new ArrayList<>();
        for(EncounterDB encounterDb : encounterDbs){
            encounters.add(Encounter.from(encounterDb));
        }
        return encounters;
    }

    @Override
    public Encounter getEncounter(String id){
        EncounterDB encounterDb = persistence.getEncounter(id);
        if(encounterDb == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return Encounter.from(encounterDb);
    }

    @Override
    public void createEncounter(Encounter encounter) {
        if(encounter == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        PersonDB existingDoctor = persistence.getPerson(encounter.getDoctor().getId());
        PersonDB existingPatient = persistence.getPerson(encounter.getPatient().getId());
        if(existingDoctor == null || existingPatient == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(!(existingDoctor.getRole().equals(Role.DOCTOR) || existingPatient.getRole().equals(Role.PATIENT)))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        EncounterDB encounterDb = encounter.toEncounterDB();
        persistence.createEncounter(encounterDb);
    }

    @Override
    public void createObservation(Observation observation, String encounterId) {
        if(observation == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        EncounterDB encounterDb = persistence.getEncounter(encounterId);
        if(encounterDb == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        ObservationDB observationDb = observation.toObservationDB();
        observationDb.setEncounter(encounterDb);
        persistence.createObservation(observationDb);
    }


    private void checkAuthorityDoctorOrSamePatient(String patientId){
        Person loggedIn = getCurrentUserPerson();
        if(!loggedIn.getRole().equals(Role.DOCTOR) && !loggedIn.getId().equals(patientId))
            throw new AccessDeniedException("No authority to access patient data");
    }

    private void checkAuthorityDoctorOrOther(){
        Person loggedIn = getCurrentUserPerson();
        if(!(loggedIn.getRole().equals(Role.DOCTOR) || loggedIn.getRole().equals(Role.OTHER)))
            throw new AccessDeniedException("No authority to create person data");
    }

    //TEST METHOD
    public void createUsers(){
        persistence.seedUsers();
    }
}
