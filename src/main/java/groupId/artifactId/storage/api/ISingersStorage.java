package groupId.artifactId.storage.api;

import groupId.artifactId.core.entity.Singer;

public interface ISingersStorage extends IEssenceStorage<Singer> {
    void save(Singer singer);
}
