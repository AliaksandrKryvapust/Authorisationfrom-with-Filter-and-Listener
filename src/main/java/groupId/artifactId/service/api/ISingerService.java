package groupId.artifactId.service.api;

import groupId.artifactId.core.entity.Singer;

public interface ISingerService extends IEEssenceService<Singer> {
    String getSinger(int id);

}
