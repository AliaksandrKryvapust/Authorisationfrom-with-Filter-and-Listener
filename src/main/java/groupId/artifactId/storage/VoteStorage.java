package groupId.artifactId.storage;

import groupId.artifactId.core.entity.Vote;
import groupId.artifactId.storage.api.IVotesStorage;

import java.util.ArrayList;
import java.util.List;

public class VoteStorage implements IVotesStorage {
    private static VoteStorage firstInstance = null;
    private final List<Vote> votes = new ArrayList<>();


    public static VoteStorage getInstance() {
        synchronized (VoteStorage.class) {
            if (firstInstance == null) {
                firstInstance = new VoteStorage();
            }
        }
        return firstInstance;
    }
    private VoteStorage(){
    }
    @Override
    public List<Vote> getEssences() {
        return this.votes;
    }

    @Override
    public Vote getEssenceById(int id) {
        return this.votes.get(id);
    }

    @Override
    public void save(Vote vote) {
        votes.add(vote);
    }
}
