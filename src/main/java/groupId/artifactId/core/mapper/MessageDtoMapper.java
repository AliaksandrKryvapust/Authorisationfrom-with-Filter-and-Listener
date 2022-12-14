package groupId.artifactId.core.mapper;

import groupId.artifactId.core.dto.MessageDto;
import groupId.artifactId.storage.entity.Message;
import groupId.artifactId.storage.entity.User;


public class MessageDtoMapper {

    public static Message messageDtoMapping(MessageDto messageDto, User author, User destination) {
        return new Message(messageDto.getDateTime(), author, destination, messageDto.getMessage());
    }
}
