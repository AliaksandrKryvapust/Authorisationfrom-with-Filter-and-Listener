package groupId.artifactId.util;

import groupId.artifactId.core.dto.MessageDto;
import groupId.artifactId.core.dto.UserDto;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Helper {
    public static UserDto createUserDto(String login, String password, String name, String dateOfBirth) {
        return new UserDto(login, password, name, LocalDate.parse(dateOfBirth));
    }

    public static MessageDto createMessageDto(LocalDateTime date, String author, String destination, String message) {
        return new MessageDto(date, author, destination, message);
    }

    public static MessageDto createMessageDtoForServlet(LocalDateTime date, String author,
                                                        String destination, String message) {

        return new MessageDto(date, author, destination, message);
    }
}
