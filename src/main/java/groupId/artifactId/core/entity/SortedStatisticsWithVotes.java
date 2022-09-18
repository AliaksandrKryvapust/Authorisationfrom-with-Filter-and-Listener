package groupId.artifactId.core.entity;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortedStatisticsWithVotes {
    private final Map<String, Integer> singersStatistic;
    private final Map<String, Integer> genresStatistic;
    private final List<String> saveMessages;

    public SortedStatisticsWithVotes(Map<String, Integer> singersStatistic, Map<String, Integer> genresStatistic,
                                     List<String> saveMessages) {
        this.singersStatistic = singersStatistic;
        this.genresStatistic = genresStatistic;
        this.saveMessages = saveMessages;
    }

    public Map<String, Integer> getSingersStatistic() {
        return singersStatistic;
    }

    public Map<String, Integer> getGenresStatistic() {
        return genresStatistic;
    }

    public List<String> getSaveMessages() {
        return saveMessages;
    }

    @Override
    public String toString() {
        return "SortedStatisticsWithVotes{" +
                "singersStatistic=" + singersStatistic +
                ", genresStatistic=" + genresStatistic +
                ", saveMessages=" + saveMessages +
                '}';
    }
}
