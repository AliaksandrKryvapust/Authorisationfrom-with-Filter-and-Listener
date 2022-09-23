package groupId.artifactId.core.dto;

import java.time.LocalDate;

public class UserDto {
    private String login;
    private String password;
    private String name;
    private LocalDate dateOfBirth;

    public UserDto(String login, String password, String name, LocalDate dateOfBirth) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
