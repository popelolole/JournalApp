package se.kthraven.journalapp.Persistence;

import se.kthraven.journalapp.Persistence.entities.UserDB;

public interface IUserPersistence {
    UserDB getUserByUsername(String username);
}
