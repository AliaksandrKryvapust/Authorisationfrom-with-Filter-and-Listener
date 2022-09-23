package groupId.artifactId.service;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.core.entity.User;
import groupId.artifactId.core.mapper.UserDtoMapper;
import groupId.artifactId.service.api.IUserService;
import groupId.artifactId.storage.UserStorage;
import groupId.artifactId.storage.api.IUserStorage;
import groupId.artifactId.util.Helper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static groupId.artifactId.core.entity.Role.ADMIN;

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
    public void validateUser(String login, String password) {
        UserDto userDto = Helper.createUserDto(login, password, "null", LocalDate.now().toString());
        this.userValidator.validateUserAndPassword(userDto); // сделать разные конструкторы
    }

    @Override
    public void validateDestination(String login) {
        UserDto userDto = Helper.createUserDto(login, "null", "null", LocalDate.now().toString());
        this.userValidator.validateUser(userDto);
    }

    @Override
    public boolean validateAdmin(String login) {
        Optional<User> user = this.storage.getByLogin(login);
        return user.orElseThrow(() -> new IllegalStateException("There is no such user.")).getRole().equals(ADMIN);
    }
}
