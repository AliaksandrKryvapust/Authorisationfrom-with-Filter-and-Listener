package groupId.artifactId.service;

import groupId.artifactId.core.entity.Genre;
import groupId.artifactId.service.api.IGenreService;
import groupId.artifactId.storage.GenresStorage;
import groupId.artifactId.storage.api.IGenresStorage;

import java.util.List;

public class GenreService implements IGenreService {
    private static GenreService firstInstance = null;
    private final IGenresStorage storage;

    private GenreService(){
        this.storage=GenresStorage.getInstance();
    }
    public static GenreService getInstance(){
        synchronized (GenreService.class) {
            if (firstInstance == null) {
                firstInstance = new GenreService();
            }
        }
        return firstInstance;
    }

    @Override
    public List<Genre> get() {
        return this.storage.getEssences();
    }

    @Override
    public Genre get(int id) {
        return this.storage.getEssenceById(id);
    }

    @Override
    public void validate(Genre item) {
        if (item==null){
            throw new IllegalStateException("None of Singers have been sent as an input");
        }
        if (item.getName()==null || item.getName().isBlank()){
            throw new IllegalArgumentException("Singer`s name is not valid");
        }
    }

    @Override
    public String getGenre(int id) {
        return this.storage.getEssences().get(id-1).getName();
    }

    @Override
    public void validateInput(String[] arr) {
        if(arr.length < 3 || arr.length > 5){
            throw new IllegalArgumentException("Array length is not valid");
        }
    }

}
