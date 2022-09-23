package groupId.artifactId.service.api;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.core.entity.User;

import java.util.Optional;

public interface IUserService extends IEEssenceService<User> {
    Optional<User> getByLogin(String login);

    void validateUser(String login, String password);

    void validateDestination(String login);

    boolean validateAdmin(String login);

    void save(UserDto userDto);
    void saveAdmin(UserDto user);
}
