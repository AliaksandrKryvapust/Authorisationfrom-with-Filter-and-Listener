package groupId.artifactId.storage;

import groupId.artifactId.core.entity.User;
import groupId.artifactId.storage.api.IUserStorage;

import java.util.*;

public class UserStorage implements IUserStorage {
    private static UserStorage firstInstance = null;
    private final List<User> userList = new ArrayList<>();

    private UserStorage() {
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
    public int getStorageSize() {
        return userList.size();
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
