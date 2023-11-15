package se.kthraven.journalapp.Model.classes;

import se.kthraven.journalapp.Model.enums.Gender;
import se.kthraven.journalapp.Model.enums.Role;
import se.kthraven.journalapp.Persistence.entities.PersonDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Doctor extends Person{

    Collection<Person> patients;

    public static Doctor from(PersonDB doctorDb){
        if(doctorDb == null)
            return null;
        Doctor doctor = new Doctor(doctorDb.getId(),
                doctorDb.getName(),
                doctorDb.getGender(),
                doctorDb.getDob(),
                doctorDb.getPhoneNumber(),
                doctorDb.getEmail(),
                doctorDb.getRole(),
                new ArrayList<>());
        Collection<PersonDB> patientDbs = doctorDb.getPatients();
        if(doctorDb.getPatients() != null){
            for(PersonDB patient : patientDbs){
                doctor.patients.add(Person.from(patient));
            }
        }
        return doctor;
    }

    public PersonDB toPersonDB(){
        PersonDB personDb = super.toPersonDB();
        if(this.patients != null) {
            Collection<PersonDB> patients = new ArrayList<>();
            for(Person patient : this.patients){
                patients.add(patient.toPersonDB());
            }
        }
        return personDb;
    }

    public Doctor(String id, String name, Gender gender, Date dob, String phoneNumber, String email, Role role, Collection<Person> patients) {
        super(id, name, gender, dob, phoneNumber, email, role);
        this.patients = patients;
    }

    public Collection<Person> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Person> patients) {
        this.patients = patients;
    }
}
