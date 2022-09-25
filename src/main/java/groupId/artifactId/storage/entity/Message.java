package groupId.artifactId.storage.entity;

import groupId.artifactId.storage.entity.User;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime dateTime;
    private User author;
    private User destination;
    private String message;

     public Message(LocalDateTime dateTime, User author, User destination, String message) {
        this.dateTime = dateTime;
        this.author = author;
        this.destination = destination;
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public User getAuthor() {
        return author;
    }

    public User getDestination() {
        return destination;
    }

    public String getMessage() {
        return message;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setDestination(User destination) {
        this.destination = destination;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "dateTime=" + dateTime +
                ", author=" + author +
                ", destination=" + destination +
                ", message='" + message + '\'' +
                '}';
    }
}
