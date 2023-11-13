package se.kthraven.journalapp.Persistence.entities;

import jakarta.persistence.*;
import se.kthraven.journalapp.Model.enums.Role;

@Entity
@Table(name = "user")
public class UserDB {
    @Id
    private String id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonDB person;

    public UserDB() {

    }

    public UserDB(String id, String username, String password, Role role, PersonDB person) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public PersonDB getPerson() {
        return person;
    }

    public void setPerson(PersonDB person) {
        this.person = person;
    }
}
