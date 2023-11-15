package se.kthraven.journalapp.Model.classes;

import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.Date;

public class Patient extends Person{

    private Condition condition;
    private Person doctor;

    public static Patient from(PersonDB patientDb){
        if(patientDb == null)
            return null;
        Patient patient = new Patient(patientDb.getId(),
                patientDb.getName(),
                patientDb.getGender(),
                patientDb.getDob(),
                patientDb.getPhoneNumber(),
                patientDb.getEmail(),
                patientDb.getRole(),
                Condition.from(patientDb.getCondition()),
                Person.from(patientDb.getDoctor()));
        return patient;
    }

    public PersonDB toPersonDB(){
        PersonDB personDb = super.toPersonDB();
        if(this.condition != null)
            personDb.setCondition(this.condition.toConditionDB());
        if(this.doctor != null)
            personDb.setDoctor(this.doctor.toPersonDB());
        return personDb;
    }

    public Patient(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Condition condition, Person doctor) {
        super(id, name, gender, dob, phoneNumber, email, role);
        this.condition = condition;
        this.doctor = doctor;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
