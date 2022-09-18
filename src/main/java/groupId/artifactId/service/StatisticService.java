package groupId.artifactId.service;

import groupId.artifactId.core.entity.SortedStatistic;
import groupId.artifactId.core.entity.SortedStatisticsWithVotes;
import groupId.artifactId.core.entity.Genre;
import groupId.artifactId.core.entity.Singer;
import groupId.artifactId.core.entity.Vote;
import groupId.artifactId.service.api.IGenreService;
import groupId.artifactId.service.api.ISingerService;
import groupId.artifactId.service.api.IStatisticService;
import groupId.artifactId.service.api.IVoteResultService;

import java.util.*;

public class StatisticService implements IStatisticService {

    private static StatisticService firstInstance=null;
    private final IVoteResultService voteResultService = VoteResultService.getInstance();
    private final IGenreService genreService = GenreService.getInstance();
    private final ISingerService singerService = SingerService.getInstance();

    private StatisticService(){}

    public static StatisticService getInstance(){
        synchronized (StatisticService.class){
            if (firstInstance==null){
                firstInstance= new StatisticService();
            }
        }
        return firstInstance;
    }

    @Override
    public void saveStatic(String singersData, String[] genresData, String massageData) {
        String[] temp = new String[genresData.length];
        for (int i = 0; i < genresData.length; i++) {
            temp[i] = genreService.getGenre(Integer.parseInt(genresData[i]));
        }
        voteResultService.save(new Vote(singerService.getSinger(Integer.parseInt(singersData)), temp, massageData));
    }

    @Override
    public List<Singer> getSingersForHtml() {
        return singerService.get();
    }

    @Override
    public List<Genre> getGenresForHtml() {
        return genreService.get();
    }

    @Override
    public SortedStatistic getSortedVotes() {
        List<String> sortedSingers = voteResultService.getSingersVoteResults();
        sortedSingers.sort(Comparator.comparing((i) -> Collections.frequency(sortedSingers, i)).reversed());
        Set<String> uniqueSingerVotes = new LinkedHashSet<>(sortedSingers);
        List<String> sortedGenres = voteResultService.getGenresVoteResults();
        sortedGenres.sort(Comparator.comparing((i) -> Collections.frequency(sortedGenres, i)).reversed());
        Set<String> uniqueGenresVotes = new LinkedHashSet<>(sortedGenres);
        List<String> sortedMessages = voteResultService.getMessagesVoteResults();
        return new SortedStatistic(new LinkedList<>(uniqueSingerVotes), new LinkedList<>(uniqueGenresVotes), new LinkedList<>(sortedMessages));
    }
    @Override
    public SortedStatisticsWithVotes getSortedVotesWithStatistic() {
        Map<String, Integer> sortedSingers = new HashMap<>();
        for (int i = 0; i < voteResultService.getSingersVoteResults().size(); i++) {
            if (!sortedSingers.containsKey(voteResultService.getSingersVoteResults().get(i))) {
                sortedSingers.put(voteResultService.getSingersVoteResults().get(i), 1);
            } else {
                sortedSingers.put(voteResultService.getSingersVoteResults().get(i), sortedSingers.get(voteResultService.getSingersVoteResults().get(i)) + 1);
            }
        }
        Map<String, Integer> sortedGenres = new HashMap<>();
        for (int i = 0; i < voteResultService.getGenresVoteResults().size(); i++) {
            if (!sortedGenres.containsKey(voteResultService.getGenresVoteResults().get(i))) {
                sortedGenres.put(voteResultService.getGenresVoteResults().get(i), 1);
            } else {
                sortedGenres.put(voteResultService.getGenresVoteResults().get(i), sortedGenres.get(voteResultService.getGenresVoteResults().get(i)) + 1);
            }
        }
        Map<String, Integer> sortedSingersVotes = new LinkedHashMap<>();
        Map<String, Integer> sortedGenresVotes = new LinkedHashMap<>();
        List<String> sortedMessages = new LinkedList<>(voteResultService.getMessagesVoteResults());
        sortedSingers.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered((i)-> sortedSingersVotes.put(i.getKey(),i.getValue()));
        sortedGenres.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered((i)-> sortedGenresVotes.put(i.getKey(),i.getValue()));
        return new SortedStatisticsWithVotes(sortedSingersVotes,sortedGenresVotes,sortedMessages);
    }
}









