package groupId.artifactId.service.api;

import groupId.artifactId.core.entity.Genre;
import groupId.artifactId.core.entity.Singer;
import groupId.artifactId.core.entity.SortedStatistic;
import groupId.artifactId.core.entity.SortedStatisticsWithVotes;

import java.util.List;

public interface IStatisticService {
    void saveStatic(String singersData, String[] genresData, String massageData);
    List<Singer> getSingersForHtml();
    List<Genre> getGenresForHtml();
    SortedStatistic getSortedVotes();
    SortedStatisticsWithVotes getSortedVotesWithStatistic();
}
