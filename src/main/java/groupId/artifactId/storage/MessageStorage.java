package groupId.artifactId.storage;

import groupId.artifactId.core.entity.Message;
import groupId.artifactId.storage.api.IMessageStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageStorage implements IMessageStorage {
    private static MessageStorage firstInstance = null;
    private final List<Message> messageList = new ArrayList<>();

    private MessageStorage() {
    }

    public static MessageStorage getInstance() {
        synchronized (MessageStorage.class) {
            if (firstInstance == null) {
                firstInstance = new MessageStorage();
            }
        }
        return firstInstance;
    }

    @Override
    public List<Message> get() {
        return this.messageList;
    }

    @Override
    public List<Message> getByDestination(String login) {
        return messageList.stream().filter((i) -> i.getDestination().getLogin().equals(login)).
                collect(Collectors.toList());
    }

    @Override
    public void save(Message message) {
        this.messageList.add(message);
    }
}

