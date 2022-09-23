package groupId.artifactId.service.api;

import groupId.artifactId.core.dto.MessageDto;

import java.util.List;

public interface IMessageService {
    List<MessageDto> getByDestination(String login);

    void validateInput(String message);

    void save(MessageDto messageDto);
}
