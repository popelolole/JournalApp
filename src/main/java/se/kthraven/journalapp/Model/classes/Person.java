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

    public static Person from(PersonDB personDb){
        if(personDb == null)
            return null;
        Person person = new Person(personDb.getId(),
                personDb.getName(),
                personDb.getGender(),
                personDb.getDob(),
                personDb.getPhoneNumber(),
                personDb.getEmail(),
                personDb.getRole());
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

        return personDb;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setGender(Gender gender) {
        this.gender = gender;
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
}
