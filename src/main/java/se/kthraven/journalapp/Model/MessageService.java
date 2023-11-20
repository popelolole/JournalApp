package se.kthraven.journalapp.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        if(!(currentUserId.equals(userId1) || currentUserId.equals(userId2)))
            throw new AccessDeniedException("No authority to access conversation");

        Collection<MessageDB> messageDbs = persistence.getConversation(userId1, userId2);
        ArrayList<Message> messages = new ArrayList<>();
        for(MessageDB messageDb : messageDbs){
            messages.add(Message.from(messageDb));
        }
        return messages;
    }

    @Override
    public void createMessage(Message message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        if(!(currentUserId.equals(message.getSenderId())))
            throw new AccessDeniedException("No authority to send message");

        MessageDB messageDb = message.toMessageDb();
        messageDb.setReceiver(userPersistence.getUserById(message.getReceiverId()));
        messageDb.setSender(userPersistence.getUserById(message.getSenderId()));

        persistence.createMessage(messageDb);
    }
}
