package groupId.artifactId.service;

import groupId.artifactId.core.entity.Vote;
import groupId.artifactId.service.api.IGenreService;
import groupId.artifactId.service.api.ISingerService;
import groupId.artifactId.service.api.IVoteResultService;
import groupId.artifactId.storage.VoteStorage;
import groupId.artifactId.storage.api.IVotesStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VoteResultService implements IVoteResultService {

    private static VoteResultService firstInstance = null;

    private final IVotesStorage storage;
    private final ISingerService singerService = SingerService.getInstance();
    private final IGenreService genreService = GenreService.getInstance();


    private VoteResultService() {
        this.storage = VoteStorage.getInstance();
    }

    public static VoteResultService getInstance() {
        synchronized (VoteResultService.class) {
            if (firstInstance == null) {
                firstInstance = new VoteResultService();
            }
        }
        return firstInstance;
    }

    @Override
    public void validateInput(String message) {
        if (message.length()==0){
            throw new IllegalArgumentException("Message is not valid");
        }
    }


    @Override
    public List<String> getSingersVoteResults() {
        return this.storage.getEssences().stream().map(Vote::getSingerVote).collect(Collectors.toList());
    }

    @Override
    public List<String> getGenresVoteResults() {
        List<String> temp = new ArrayList<>();
        for (String[] arr : this.storage.getEssences().stream().map(Vote::getGenresVote).collect(Collectors.toList())) {
            temp.addAll(Arrays.asList(arr));
        }
        return temp;
    }

    @Override
    public List<String> getMessagesVoteResults() {
        return this.storage.getEssences().stream().map(Vote::getSavedMessages).collect(Collectors.toList());
    }

    @Override
    public void validate(String singer, String[] genreArr, String message) {
        singerService.validate(singerService.get(Integer.parseInt(singer)));
        for (String str: genreArr) {
            genreService.validate(genreService.get(Integer.parseInt(str)));
        }
        genreService.validateInput(genreArr);
       this.validateInput(message);
    }

    @Override
    public void save(Vote vote) {
        this.storage.save(vote);
    }

}
