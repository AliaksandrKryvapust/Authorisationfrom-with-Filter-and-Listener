package groupId.artifactId.service.api;

import groupId.artifactId.core.entity.Genre;

public interface IGenreService extends IEEssenceService<Genre> {
    String getGenre(int id);
    void validateInput(String[] arr);
}
