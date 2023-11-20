package se.kthraven.journalapp.Model.classes;

import se.kthraven.journalapp.Persistence.entities.MessageDB;
import se.kthraven.journalapp.Persistence.entities.UserDB;

import java.util.Date;

public class Message {
    private String id;
    private String message;
    private Date sendDate;
    private String senderId;
    private String receiverId;

    public static Message from(MessageDB messageDb){
        if(messageDb == null)
            return null;
        Message message = new Message(messageDb.getId(),
                messageDb.getMessage(),
                messageDb.getSendDate(),
                messageDb.getSender().getId(),
                messageDb.getReceiver().getId());
        return message;
    }

    public MessageDB toMessageDb(){
        MessageDB messageDb = new MessageDB(this.id,
        this.message,
        this.sendDate,
        null,
        null);
        return messageDb;
    }

    public Message(){}

    public Message(String id, String message, Date sendDate, String senderId, String receiverId) {
        this.id = id;
        this.message = message;
        this.sendDate = sendDate;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
}
