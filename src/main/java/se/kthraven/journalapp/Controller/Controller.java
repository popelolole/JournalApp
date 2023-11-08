package se.kthraven.journalapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.kthraven.journalapp.Model.IJournalService;
import se.kthraven.journalapp.Model.classes.Person;

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
    public Person person(@RequestParam(value = "id", defaultValue="test") String id){
        Person person = journalService.getPerson(id);
        return person;
    }
}
