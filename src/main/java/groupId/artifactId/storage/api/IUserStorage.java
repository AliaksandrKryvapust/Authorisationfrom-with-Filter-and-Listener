package groupId.artifactId.storage.api;

import groupId.artifactId.core.entity.User;

public interface IUserStorage extends IEssenceStorage<User> {
    void save(User user);
}
