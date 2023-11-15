package se.kthraven.journalapp.Persistence;

import jakarta.persistence.EntityManager;
import se.kthraven.journalapp.Persistence.entities.UserDB;

public class UserPersistence implements IUserPersistence{
    @Override
    public UserDB getUserByUsername(String username) {
        EntityManager em = DBManager.getEntityManager();

        UserDB user = em.createQuery("SELECT u FROM UserDB u WHERE u.username = :uname", UserDB.class)
                .setParameter("uname", username)
                .getSingleResult();
        em.close();

        return user;
    }
}
