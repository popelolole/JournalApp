package se.kthraven.journalapp.Model;

import se.kthraven.journalapp.Model.classes.CustomUserDetails;
import se.kthraven.journalapp.Model.classes.Message;

import java.util.Collection;

public interface IMessageService {
    Collection<Message> getConversation(String userId1, String userId2);
    //MessageDB getMessage(String id);
    void createMessage(Message message);
}
