package se.kthraven.journalapp.Persistence;

import se.kthraven.journalapp.Persistence.entities.UserDB;

public interface IUserPersistence {
    UserDB getUserById(String id);
    UserDB getUserByUsername(String username);
}
