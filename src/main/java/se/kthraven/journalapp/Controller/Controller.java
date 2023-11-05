package se.kthraven.journalapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.kthraven.journalapp.Model.IJournalService;
import se.kthraven.journalapp.Model.JournalService;
import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Model.records.Person;

import java.util.Calendar;
import java.util.Date;
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
    public Person patient(@RequestParam(value = "id", defaultValue="test") String id){
        Person patient = journalService.getPatient(id);
        return patient;
    }
}
