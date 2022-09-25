package groupId.artifactId.service;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.core.dto.VerificationDto;
import groupId.artifactId.core.entity.User;
import groupId.artifactId.service.api.IUserValidator;
import groupId.artifactId.storage.UserStorage;
import groupId.artifactId.storage.api.IUserStorage;

import java.time.LocalDate;
import java.util.Optional;

public class UserValidator implements IUserValidator {

    private static UserValidator firstInstance = null;
    private final IUserStorage storage;

    private UserValidator() {
        this.storage = UserStorage.getInstance();
    }

    public static UserValidator getInstance() {
        synchronized (UserValidator.class) {
            if (firstInstance == null) {
                firstInstance = new UserValidator();
            }
        }
        return firstInstance;

    }

    @Override
    public void validate(UserDto item) {
        if (item == null) {
            throw new IllegalStateException("Error code 500. None of Users have been sent as an input");
        }
        if (item.getLogin() == null || item.getLogin().isBlank()) {
            throw new IllegalArgumentException("Error code 400. Login is not valid");
        }
        if (item.getPassword() == null || item.getLogin().isBlank()) {
            throw new IllegalArgumentException("Error code 400. Password is not valid");
        }
        if (item.getName() == null || item.getLogin().isBlank()) {
            throw new IllegalArgumentException("Error code 400. Name is not valid");
        }
        if (LocalDate.EPOCH.isAfter(item.getDateOfBirth()) || LocalDate.now().isBefore(item.getDateOfBirth())) {
            throw new IllegalArgumentException("Error code 400. Date of birth is not valid");
        }
    }

    @Override
    public void validateUser(UserDto item) {

        Optional<User> user = this.storage.getByLogin(item.getLogin());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("Error code 400. There is no such user login");
        }
    }
    @Override
    public void validateVerificationDto(VerificationDto verificationDto) {
        Optional<User> user = this.storage.getByLogin(verificationDto.getLogin());
        if (user.isEmpty() || !user.get().getPassword().equals(verificationDto.getPassword())) {
            throw new IllegalArgumentException("Error code 400. Login or password is not valid");
        }
    }
}