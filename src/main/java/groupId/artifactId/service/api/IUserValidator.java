package groupId.artifactId.service.api;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.core.dto.VerificationDto;

public interface IUserValidator {
    void validate(UserDto item);

    void validateUser(UserDto item);
    void validateVerificationDto(VerificationDto verificationDto);
}
