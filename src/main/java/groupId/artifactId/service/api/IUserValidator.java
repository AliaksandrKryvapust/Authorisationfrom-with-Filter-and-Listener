package groupId.artifactId.service.api;

import groupId.artifactId.core.dto.UserDto;

public interface IUserValidator {
    void validate(UserDto item);

    void validateUser(UserDto item);

    void validateUserAndPassword(UserDto item);
}
