package groupId.artifactId.service;

import groupId.artifactId.core.entity.Singer;
import groupId.artifactId.service.api.ISingerService;
import groupId.artifactId.storage.SingersStorage;
import groupId.artifactId.storage.api.ISingersStorage;

import java.util.List;

public class SingerService implements ISingerService {
    private static SingerService firstInstance =null;
    private final ISingersStorage storage;

    private SingerService(){
        this.storage= SingersStorage.getInstance();
    }
    public static SingerService getInstance() {
        synchronized (SingerService.class) {
            if (firstInstance == null) {
                firstInstance = new SingerService();
            }
        }
        return firstInstance;
    }

    @Override
    public List<Singer> get() {
        return this.storage.getEssences();
    }

    @Override
    public Singer get(int id) {
        return this.storage.getEssenceById(id);
    }

    @Override
    public void validate(Singer item) {
        if (item == null) {
            throw new IllegalStateException("None of Singers have been sent as an input");
        }
        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException("Singer`s name is not valid");
        }
    }

    @Override
    public String getSinger(int id) {
        return this.storage.getEssences().get(id-1).getName();
    }

}
