package se.kthraven.journalapp.Persistence;

import se.kthraven.journalapp.Persistence.entities.MessageDB;
import se.kthraven.journalapp.Persistence.entities.UserDB;

import java.util.Collection;

public interface IMessagePersistence {
    Collection<MessageDB> getConversation(String userId1, String userId2);
    void createMessage(MessageDB message);
}
