package groupId.artifactId.core.mapper;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.core.entity.Role;
import groupId.artifactId.core.entity.User;
import groupId.artifactId.core.entity.UserBuilder;

import java.time.LocalDate;

public class UserDtoMapper {
    public static User userDtoMapping(UserDto userDto) {
        return UserBuilder.create().setLogin(userDto.getLogin()).setPassword(userDto.getPassword()).
                setName(userDto.getName()).setDateOfBirth(userDto.getDateOfBirth()).
                setRegistrationDate(LocalDate.now()).setRole(Role.USER).build();
    }
    public static User adminDtoMapping(UserDto userDto) {
        return UserBuilder.create().setLogin(userDto.getLogin()).setPassword(userDto.getPassword()).
                setName(userDto.getName()).setDateOfBirth(userDto.getDateOfBirth()).
                setRegistrationDate(LocalDate.now()).setRole(Role.ADMIN).build();
    }
}
