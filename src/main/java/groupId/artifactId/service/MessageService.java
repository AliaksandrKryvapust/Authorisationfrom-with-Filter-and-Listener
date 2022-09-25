package groupId.artifactId.service;

import groupId.artifactId.core.dto.MessageDto;
import groupId.artifactId.storage.entity.Message;
import groupId.artifactId.storage.entity.User;
import groupId.artifactId.core.mapper.MessageDtoMapper;
import groupId.artifactId.service.api.IMessageService;
import groupId.artifactId.service.api.IUserService;
import groupId.artifactId.storage.MessageStorage;
import groupId.artifactId.storage.api.IMessageStorage;

import java.util.ArrayList;
import java.util.List;

public class MessageService implements IMessageService {

    private static MessageService firstInstance = null;
    private final IMessageStorage storage;
    private final MessageValidator messageDtoValidate;
    private final IUserService userService;

    private MessageService() {
        this.storage = MessageStorage.getInstance();
        this.messageDtoValidate = MessageValidator.getInstance();
        this.userService = UserService.getInstance();
    }

    public static MessageService getInstance() {
        synchronized (MessageService.class) {
            if (firstInstance == null) {
                firstInstance = new MessageService();
            }
        }
        return firstInstance;
    }

    @Override
    public List<MessageDto> getByDestination(String login) {
        List<MessageDto> temp = new ArrayList<>();
        for (Message message : this.storage.getByDestination(login)) {
            temp.add(new MessageDto(message.getDateTime(), message.getAuthor().getLogin(),
                    message.getDestination().getLogin(), message.getMessage()));
        }
        return temp;
    }

    @Override
    public int getSize() {
        return this.storage.getStorageSize();
    }

    @Override
    public void validateInput(String message) {
        if (message.length() == 0) {
            throw new IllegalArgumentException("Message is not valid");
        }
    }

    @Override
    public void save(MessageDto messageDto) {
        this.messageDtoValidate.validate(messageDto);
        User author = this.userService.getByLogin(messageDto.getAuthor()).
                orElseThrow(() -> new IllegalStateException("Error code 500.There is no Author in Dto"));
        User destination = this.userService.getByLogin(messageDto.getDestination()).
                orElseThrow(() -> new IllegalStateException("Error code 500.There is no Destination in Dto"));
        this.storage.save(MessageDtoMapper.messageDtoMapping(messageDto, author, destination));
    }

}
