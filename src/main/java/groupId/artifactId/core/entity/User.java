package groupId.artifactId.core.entity;

import java.time.LocalDate;

public class User {
    private final String login;
    private final String password;
    private final String name;
    private final LocalDate dateOfBirth;
    private final LocalDate registrationDate;
    private final Role role;

    User(String login, String password, String name, LocalDate dateOfBirth, LocalDate registrationDate, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", registrationDate=" + registrationDate +
                ", role=" + role +
                '}';
    }
}
