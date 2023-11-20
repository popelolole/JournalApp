package se.kthraven.journalapp.Controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import se.kthraven.journalapp.Model.CustomUserDetailsService;
import se.kthraven.journalapp.Model.IJournalService;
import se.kthraven.journalapp.Model.IMessageService;
import se.kthraven.journalapp.Model.classes.*;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    @Autowired
    private IJournalService journalService;

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private IMessageService messageService;

    @GetMapping("/login")
    public ResponseEntity<UserDetails> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        UserDetails user = userService.login(username, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user")
    public String getUserId(@RequestParam(value = "personId") String personId){
        return userService.getUserIdByPersonId(personId);
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
    public Observation createObservation(@RequestBody Observation observation, @RequestParam(value = "encounterId") String encounterId){
        journalService.createObservation(observation, encounterId);
        return observation;
    }

    @GetMapping("/messages")
    public Collection<Message> getConversation(@RequestParam String userId1, @RequestParam String userId2){
        return messageService.getConversation(userId1, userId2);
    }

    @PostMapping("/message")
    public Message createMessage(@RequestBody Message message){
        messageService.createMessage(message);
        return message;
    }
}
