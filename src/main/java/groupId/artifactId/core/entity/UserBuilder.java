package groupId.artifactId.core.entity;

import java.time.LocalDate;

public class UserBuilder {
    private String login;
    private String password;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate registrationDate;
    private Role role;

    private UserBuilder() {
    }

    public static UserBuilder create() {
        return new UserBuilder();
    }

    public UserBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UserBuilder setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public UserBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public User build() {
        return new User(login, password, name, dateOfBirth, registrationDate, role);
    }
}
