package groupId.artifactId.core.dto;

import java.time.LocalDateTime;

public class MessageDto {
    private LocalDateTime dateTime;
    private String author;
    private String destination;
    private String message;

    public MessageDto(LocalDateTime time, String author, String destination, String message) {
        this.dateTime = time;
        this.author = author;
        this.destination = destination;
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getAuthor() {
        return author;
    }

    public String getDestination() {
        return destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
