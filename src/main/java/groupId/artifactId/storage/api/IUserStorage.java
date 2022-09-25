package groupId.artifactId.storage.api;

import groupId.artifactId.core.entity.User;

import java.util.List;

public interface IUserStorage extends IEssenceStorage<User> {
    void save(User user);
    public int getStorageSize();
}
