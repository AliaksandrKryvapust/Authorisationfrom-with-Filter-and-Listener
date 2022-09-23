package groupId.artifactId.storage;

import groupId.artifactId.core.entity.User;
import groupId.artifactId.core.entity.UserBuilder;
import groupId.artifactId.storage.api.IUserStorage;

import java.time.LocalDate;
import java.util.*;

import static groupId.artifactId.core.entity.Role.ADMIN;

public class UserStorage implements IUserStorage {
    private static UserStorage firstInstance = null;
    private final List<User> userList = new ArrayList<>();

    private UserStorage(){
        this.userList.add(UserBuilder.create().setLogin("Admin").setPassword("Spark").setName("Admin").
                setDateOfBirth(LocalDate.of(1990, 1, 1)).setRegistrationDate(LocalDate.of(1990,1,1)).setRole(ADMIN).build());
    }
    public static UserStorage getInstance() {
        synchronized (UserStorage.class) {
            if (firstInstance == null) {
                firstInstance = new UserStorage();
            }
        }
        return firstInstance;
    }

    @Override
    public List<User> get() {
        return this.userList;
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return this.userList.stream().filter((i) -> i.getLogin().equals(login)).findFirst();
    }

    @Override
    public void save(User user) {
        this.userList.add(user);
    }
}
