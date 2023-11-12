package se.kthraven.journalapp.Persistence.entities;

import jakarta.persistence.*;
import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "person")
public class PersonDB {

    @Id
    private String id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date dob;
    @Column(name="phone_number")
    private String phoneNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="condition_id")
    private ConditionDB condition;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<PersonDB> patients;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private PersonDB doctor;

    public PersonDB() {
    }

    public PersonDB(String id, String name, Gender gender, Date dob, Role role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.role = role;
    }

    public PersonDB(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }

    public PersonDB(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, ConditionDB condition, PersonDB doctor) {
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

    public PersonDB(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Collection<PersonDB> patients) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.patients = patients;
    }

    public PersonDB(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, ConditionDB condition, Collection<PersonDB> patients, PersonDB doctor) {
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

    public void setGender(Gender gender){
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

    public ConditionDB getCondition() {
        return condition;
    }

    public void setCondition(ConditionDB condition) {
        this.condition = condition;
    }

    public Collection<PersonDB> getPatients() {
        return patients;
    }

    public void setPatients(Collection<PersonDB> patients) {
        this.patients = patients;
    }

    public PersonDB getDoctor() {
        return doctor;
    }

    public void setDoctor(PersonDB doctor) {
        this.doctor = doctor;
    }
}
