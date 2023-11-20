package se.kthraven.journalapp.Persistence;

import jakarta.persistence.EntityManager;
import se.kthraven.journalapp.Persistence.entities.EncounterDB;
import se.kthraven.journalapp.Persistence.entities.MessageDB;
import se.kthraven.journalapp.Persistence.entities.UserDB;

import java.util.Collection;
import java.util.UUID;

public class MessagePersistence implements IMessagePersistence{
    @Override
    public Collection<MessageDB> getConversation(String userId1, String userId2) {
        EntityManager em = DBManager.getEntityManager();
        Collection<MessageDB> messages = em.createQuery("SELECT m FROM MessageDB m WHERE (m.sender.id = :sid1 AND m.receiver.id = :rid1) OR (m.sender.id = :sid2 AND m.receiver.id = :rid2)" +
                        "order by sendDate", MessageDB.class)
                .setParameter("sid1", userId1)
                .setParameter("rid1", userId2)
                .setParameter("sid2", userId2)
                .setParameter("rid2", userId1)
                .getResultList();
        em.close();
        return messages;
    }

    @Override
    public void createMessage(MessageDB message) {
        EntityManager em = DBManager.getEntityManager();
        em.getTransaction().begin();

        message.setId(UUID.randomUUID().toString());
        em.persist(message);

        em.getTransaction().commit();
        em.close();
    }
}
