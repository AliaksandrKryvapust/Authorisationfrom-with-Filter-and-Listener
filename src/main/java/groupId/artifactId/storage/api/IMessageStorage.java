package groupId.artifactId.storage.api;

import groupId.artifactId.core.entity.Message;

import java.util.List;

public interface IMessageStorage {
    List<Message> get();

    List<Message> getByDestination(String login);

    void save(Message message);
}
