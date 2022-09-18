package groupId.artifactId.core.entity;

import java.util.Arrays;

public class Vote {
    private final String singerVote;
    private final String[] genresVote;
    private final String savedMessages;

    public Vote(String singerVote, String [] genresVote, String savedMessages) {
        this.singerVote=singerVote;
        this.genresVote=genresVote;
        this.savedMessages=savedMessages;
    }

    public String getSingerVote() {
        return singerVote;
    }

    public String[] getGenresVote() {
        return genresVote;
    }

    public String getSavedMessages() {
        return savedMessages;
    }

    @Override
    public String toString() {
        return "VoteResult{" +
                "singerVote='" + singerVote + '\'' +
                ", genresVote=" + Arrays.toString(genresVote) +
                ", savedMessages='" + savedMessages + '\'' +
                '}';
    }
}
