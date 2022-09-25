package groupId.artifactId.storage.api;

import groupId.artifactId.storage.entity.User;

public interface IUserStorage extends IEssenceStorage<User> {
    void save(User user);
    public int getStorageSize();
}
