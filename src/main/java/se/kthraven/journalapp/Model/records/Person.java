package se.kthraven.journalapp.Model.records;

import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public record Person(String id, String name, Gender gender,
                     Date dob, String phoneNumber, String email,
                     Role role, Condition condition, Collection<Person> patients) {
    public Person(String id, String name, Gender gender, Date dob, Role role) {
        this(id, name, gender, dob, null, null, role, null, new ArrayList<>());
    }

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role){
        this(id, name, gender, dob, phoneNumber, email, role, null, new ArrayList<>());
    }

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Condition condition){
        this(id, name, gender, dob, phoneNumber, email, role, condition, new ArrayList<>());
    }

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Collection<Person> patients){
        this(id, name, gender, dob, phoneNumber, email, role, null, patients);
    }
}
