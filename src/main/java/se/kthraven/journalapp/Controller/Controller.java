package se.kthraven.journalapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import se.kthraven.journalapp.Model.IJournalService;
import se.kthraven.journalapp.Model.classes.*;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IJournalService journalService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/patient")
    public Patient getPatient(@RequestParam(value = "id") String id){
        Patient patient = journalService.getPatient(id);
        return patient;
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR') or hasRole('ROLE_OTHER')")
    @PostMapping("/patient")
    public ResponseEntity<String> createPatient(@RequestBody Patient patient){
        journalService.createPatient(patient);
        return new ResponseEntity<>("Person created successfully", HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR') or hasRole('ROLE_OTHER')")
    @GetMapping("/doctor")
    public Doctor getDoctor(@RequestParam(value = "id") String id){
        Doctor doctor = journalService.getDoctor(id);
        return doctor;
    }

    @GetMapping("/patient/encounters")
    public Collection<Encounter> patientEncounters(@RequestParam(value = "patientId") String patientId){
        Collection<Encounter> encounters = journalService.getEncountersByPatient(patientId);
        return encounters;
    }

    @GetMapping("/encounter")
    public Encounter getEncounter(@RequestParam(value = "id") String id){
        Encounter encounter = journalService.getEncounter(id);
        return encounter;
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR') or hasRole('ROLE_OTHER')")
    @PostMapping("/encounter")
    public ResponseEntity<String> createEncounter(@RequestBody Encounter encounter){
        journalService.createEncounter(encounter);
        return new ResponseEntity<>("Encounter created successfully", HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR') or hasRole('ROLE_OTHER')")
    @PostMapping("/encounter/observation")
    public ResponseEntity<String> createObservation(@RequestBody Observation observation, @RequestParam(value = "encounterId") String encounterId){
        journalService.createObservation(observation, encounterId);
        return new ResponseEntity<>("Encounter created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/seed")
    public void seed(){
        se.kthraven.journalapp.Persistence.JournalPersistence.seedData();
    }
}
