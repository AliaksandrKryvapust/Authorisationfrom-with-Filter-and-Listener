package groupId.artifactId.service;

import groupId.artifactId.core.dto.MessageDto;
import groupId.artifactId.service.api.IMessageValidator;

public class MessageValidator implements IMessageValidator {

    private static MessageValidator firstInstance = null;

    private MessageValidator() {
    }

    public static MessageValidator getInstance() {
        synchronized (MessageValidator.class) {
            if (firstInstance == null) {
                firstInstance = new MessageValidator();
            }
        }
        return firstInstance;

    }

    @Override
    public void validate(MessageDto item) {
        if (item == null) {
            throw new IllegalStateException("Error code 500. None of Messages have been sent as an input");
        }
        if (item.getAuthor() == null || item.getAuthor().isBlank()) {
            throw new IllegalStateException("Error code 500. None of Authors have been sent as an input");
        }
        if (item.getDestination() == null || item.getDestination().isBlank()) {
            throw new IllegalArgumentException("Error code 400. Destination user is not valid");
        }
        if (item.getMessage() == null || item.getMessage().isBlank()) {
            throw new IllegalArgumentException("Error code 400. Message field is empty");
        }
        if (item.getDateTime() == null) {
            throw new IllegalStateException("Error code 500. No datetime have been sent as an input");
        }
    }
}
