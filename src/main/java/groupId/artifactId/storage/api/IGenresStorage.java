package groupId.artifactId.storage.api;

import groupId.artifactId.core.entity.Genre;

public interface IGenresStorage extends IEssenceStorage<Genre>{
    void save(Genre genre);
}
