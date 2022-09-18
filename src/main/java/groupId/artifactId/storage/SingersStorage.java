package groupId.artifactId.storage;

import groupId.artifactId.core.entity.Singer;
import groupId.artifactId.core.entity.SingerBuilder;
import groupId.artifactId.storage.api.ISingersStorage;

import java.util.*;

public class SingersStorage implements ISingersStorage {
    private static SingersStorage firstInstance = null;
    private final List<Singer> singerList = new ArrayList<>();

    private SingersStorage(){
        this.singerList.add(SingerBuilder.create().setId(1).setName("Michael Jackson").build());
        this.singerList.add(SingerBuilder.create().setId(2).setName("Stevie Wonder").build());
        this.singerList.add(SingerBuilder.create().setId(3).setName("Marvin Gaye").build());
        this.singerList.add(SingerBuilder.create().setId(4).setName("Freddie Mercury").build());
    }
    public static SingersStorage getInstance() {
        synchronized (SingersStorage.class) {
            if (firstInstance == null) {
                firstInstance = new SingersStorage();
            }
        }
        return firstInstance;
    }

    @Override
    public List<Singer> getEssences() {
        return this.singerList;
    }

    @Override
    public Singer getEssenceById(int id) {
        return this.singerList.stream().filter((i)->i.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void save(Singer singer) {
        this.singerList.add(singer);
    }
}
