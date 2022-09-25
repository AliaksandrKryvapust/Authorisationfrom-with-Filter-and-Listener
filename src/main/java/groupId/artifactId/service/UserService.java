package groupId.artifactId.service;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.core.entity.User;
import groupId.artifactId.core.mapper.UserDtoMapper;
import groupId.artifactId.service.api.IUserService;
import groupId.artifactId.storage.UserStorage;
import groupId.artifactId.storage.api.IUserStorage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static groupId.artifactId.core.entity.Role.ADMIN;
import static groupId.artifactId.core.entity.Role.USER;

public class UserService implements IUserService {
    private static UserService firstInstance = null;
    private final IUserStorage storage;
    private final UserValidator userValidator;

    private UserService() {
        this.storage = UserStorage.getInstance();
        this.userValidator = UserValidator.getInstance();
    }

    public static UserService getInstance() {
        synchronized (UserService.class) {
            if (firstInstance == null) {
                firstInstance = new UserService();
            }
        }
        return firstInstance;
    }

    @Override
    public List<User> getList() {
        return this.storage.get();
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return this.storage.getByLogin(login);
    }

    @Override
    public int getSize() {
        return this.storage.getStorageSize();
    }

    @Override
    public void save(UserDto user) {
        this.userValidator.validate(user);
        this.storage.save(UserDtoMapper.userDtoMapping(user));
    }

    @Override
    public void saveAdmin(UserDto user) {
        this.userValidator.validate(user);
        this.storage.save(UserDtoMapper.adminDtoMapping(user));
    }

    @Override
    public void validateDestination(String login) {
        UserDto userDto = new UserDto(login, "null", "null", LocalDate.now());
        this.userValidator.validateUser(userDto);
    }

    @Override
    public boolean validateAdmin(String login) {
        Optional<User> user = this.storage.getByLogin(login);
        return user.orElseThrow(() -> new IllegalStateException("There is no such user.")).getRole().equals(ADMIN);
    }

    @Override
    public boolean validateUser(String login) {
        Optional<User> user = this.storage.getByLogin(login);
        return user.orElseThrow(() -> new IllegalStateException("There is no such user.")).getRole().equals(USER);
    }
}
