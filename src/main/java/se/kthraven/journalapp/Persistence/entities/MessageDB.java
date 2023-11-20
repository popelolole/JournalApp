package se.kthraven.journalapp.Persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "message")
public class MessageDB {
    @Id
    private String id;
    private String message;
    @Column(name="send_date")
    private Date sendDate;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserDB sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserDB receiver;

    public MessageDB(){

    }

    public MessageDB(String id, String message, Date sendDate, UserDB sender, UserDB receiver) {
        this.id = id;
        this.message = message;
        this.sendDate = sendDate;
        this.sender = sender;
        this.receiver = receiver;
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

    public UserDB getSender() {
        return sender;
    }

    public void setSender(UserDB sender) {
        this.sender = sender;
    }

    public UserDB getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDB receiver) {
        this.receiver = receiver;
    }
}
