package groupId.artifactId.storage;

import groupId.artifactId.core.entity.Genre;
import groupId.artifactId.core.entity.GenreBuilder;
import groupId.artifactId.storage.api.IGenresStorage;

import java.util.ArrayList;
import java.util.List;

public class GenresStorage implements IGenresStorage {
    private static GenresStorage firstInstance = null;
    private final List<Genre> genreList = new ArrayList<>();

    private GenresStorage() {
        this.genreList.add(GenreBuilder.create().setId(1).setName("Rock").build());
        this.genreList.add(GenreBuilder.create().setId(2).setName("Jazz").build());
        this.genreList.add(GenreBuilder.create().setId(3).setName("Electronic Dance Music").build());
        this.genreList.add(GenreBuilder.create().setId(4).setName("Dub-step").build());
        this.genreList.add(GenreBuilder.create().setId(5).setName("Techno").build());
        this.genreList.add(GenreBuilder.create().setId(6).setName("Rhythm and Blues").build());
        this.genreList.add(GenreBuilder.create().setId(7).setName("Country").build());
        this.genreList.add(GenreBuilder.create().setId(8).setName("Pop").build());
        this.genreList.add(GenreBuilder.create().setId(9).setName("Alternative Rock").build());
        this.genreList.add(GenreBuilder.create().setId(10).setName("Classical music").build());
    }

    public static GenresStorage getInstance() {
        synchronized (GenresStorage.class) {
            if (firstInstance == null) {
                firstInstance = new GenresStorage();
            }
        }
        return firstInstance;
    }

    @Override
    public List<Genre> getEssences() {
        return this.genreList;
    }

    @Override
    public Genre getEssenceById(int id) {
        return this.genreList.stream().filter((i)->i.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void save(Genre genre) {
        this.genreList.add(genre);
    }
}

