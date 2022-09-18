package groupId.artifactId.storage.api;

import groupId.artifactId.core.entity.Vote;

public interface IVotesStorage extends IEssenceStorage<Vote>{
    void save(Vote vote);
}
