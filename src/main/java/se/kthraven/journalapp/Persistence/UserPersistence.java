package se.kthraven.journalapp.Persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import se.kthraven.journalapp.Persistence.entities.UserDB;

public class UserPersistence implements IUserPersistence{
    @Override
    public UserDB getUserById(String id) {
        EntityManager em = DBManager.getEntityManager();

        UserDB user = em.find(UserDB.class, id);

        em.close();
        return user;
    }

    @Override
    public UserDB getUserByPersonId(String personId) {
        UserDB user = null;
        try(EntityManager em = DBManager.getEntityManager()) {
            user = em.createQuery("SELECT u FROM UserDB u WHERE u.person.id = :pid", UserDB.class)
                    .setParameter("pid", personId)
                    .getSingleResult();
        }
        catch(NoResultException ignored){
        }

        return user;
    }

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
