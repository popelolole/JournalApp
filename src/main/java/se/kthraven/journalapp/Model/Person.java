package se.kthraven.journalapp.Model;

import java.util.Collection;
import java.util.Date;

public class Person {
    private final String id;
    private String name;
    private final Gender gender;
    private Date dob;
    private String phoneNumber;
    private String email;
    private Role role;
    private Condition condition;
    private Collection<Person> patients;

    public Person(String id, String name, Gender gender, Date dob, Role role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.role = role;
    }

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Condition condition) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.condition = condition;
    }

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Collection<Person> patients) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.patients = patients;
    }

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Condition condition, Collection<Person> patients) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.condition = condition;
        this.patients = patients;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Collection<Person> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Person> patients) {
        this.patients = patients;
    }
}
