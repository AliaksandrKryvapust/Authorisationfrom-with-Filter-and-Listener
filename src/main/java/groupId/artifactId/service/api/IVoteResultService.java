package groupId.artifactId.service.api;

import groupId.artifactId.core.entity.Vote;

import java.util.List;

public interface IVoteResultService {
    List<String> getSingersVoteResults();

    List<String> getGenresVoteResults();

    List<String> getMessagesVoteResults();

    void validate(String singer, String[] genreArr, String message);
    void validateInput(String message);

    void save(Vote vote);
}
