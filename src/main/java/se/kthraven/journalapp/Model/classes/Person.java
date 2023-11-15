package se.kthraven.journalapp.Model.classes;

import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Person {
    private String id;
    private String name;
    private Gender gender;
    private Date dob;
    private String phoneNumber;
    private String email;
    private Role role;
    private Condition condition;
    private Collection<Person> patients;
    private Person doctor;

    public static Person from(PersonDB personDb){
        if(personDb == null)
            return null;
        Person person = new Person();
        person.id = personDb.getId();
        person.name = personDb.getName();
        person.gender = personDb.getGender();
        person.dob = personDb.getDob();
        person.phoneNumber = personDb.getPhoneNumber();
        person.email = personDb.getEmail();
        person.role = personDb.getRole();
        person.condition = Condition.from(personDb.getCondition());

        persons.put(person.id, person);

        person.doctor = from(personDb.getDoctor());

        Collection<PersonDB> patientDbs = personDb.getPatients();
        Collection<Person> patients = new ArrayList<>();

        //Change this
        if(patientDbs != null) {
            for (PersonDB patientDb : patientDbs) {
                Person patient = null;
                if (persons.get(patientDb.getId()) != null) {
                    patients = null;
                    break;
                } else {
                    patient = from(patientDb);
                }
                patients.add(patient);
            }
        }
        person.patients = patients;
        return person;
    }

    public PersonDB toPersonDB(){
        PersonDB personDb = new PersonDB(this.id,
                this.name,
                this.gender,
                this.dob,
                this.phoneNumber,
                this.email,
                this.role,
                null,
                null,
                null);

        if(this.condition != null)
            personDb.setCondition(this.condition.toConditionDB());
        if(this.doctor != null)
            personDb.setDoctor(this.doctor.toPersonDB());

        return personDb;
    }

    private static HashMap<String, Person> persons = new HashMap<>();

    public Person(){

    }

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

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Condition condition, Person doctor) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.condition = condition;
        this.doctor = doctor;
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

    public Person(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Condition condition, Collection<Person> patients, Person doctor) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.condition = condition;
        this.patients = patients;
        this.doctor = doctor;
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

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }
}
