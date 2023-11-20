package se.kthraven.journalapp.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.kthraven.journalapp.Model.classes.CustomUserDetails;
import se.kthraven.journalapp.Model.classes.Encounter;
import se.kthraven.journalapp.Model.classes.Message;
import se.kthraven.journalapp.Persistence.IMessagePersistence;
import se.kthraven.journalapp.Persistence.IUserPersistence;
import se.kthraven.journalapp.Persistence.entities.EncounterDB;
import se.kthraven.journalapp.Persistence.entities.MessageDB;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MessageService implements IMessageService{

    @Autowired
    private IMessagePersistence persistence;

    @Autowired
    private IUserPersistence userPersistence;

    @Override
    public Collection<Message> getConversation(String userId1, String userId2) {
        Collection<MessageDB> messageDbs = persistence.getConversation(userId1, userId2);
        if(messageDbs.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        ArrayList<Message> messages = new ArrayList<>();
        for(MessageDB messageDb : messageDbs){
            messages.add(Message.from(messageDb));
        }
        return messages;
    }

    @Override
    public void createMessage(Message message) {
        MessageDB messageDb = message.toMessageDb();
        messageDb.setReceiver(userPersistence.getUserById(message.getReceiverId()));
        messageDb.setSender(userPersistence.getUserById(message.getSenderId()));

        persistence.createMessage(messageDb);
    }
}
