package groupId.artifactId.service;

import groupId.artifactId.core.entity.Statistic;
import groupId.artifactId.service.api.IStatisticService;
import groupId.artifactId.storage.MessageStorage;
import groupId.artifactId.storage.UserStorage;
import groupId.artifactId.storage.api.IMessageStorage;
import groupId.artifactId.storage.api.IUserStorage;

import java.util.concurrent.atomic.AtomicInteger;

public class StatisticService implements IStatisticService {

    private static StatisticService firstInstance = null;
    private static final AtomicInteger sessionCounter = new AtomicInteger(0);
    private final IMessageStorage storage;
    private final IUserStorage userStorage;

    private StatisticService() {
        this.storage = MessageStorage.getInstance();
        this.userStorage = UserStorage.getInstance();
    }

    public static StatisticService getInstance() {
        synchronized (StatisticService.class) {
            if (firstInstance == null) {
                firstInstance = new StatisticService();
            }
        }
        return firstInstance;
    }

    public static void decrSessionCounter() {
        sessionCounter.decrementAndGet();
    }

    public static void incrSessionCounter() {
        sessionCounter.incrementAndGet();
    }

    @Override
    public Statistic getData() {
        return new Statistic(sessionCounter.get(), userStorage.get().size(), storage.get().size()); // переписать get()
    }
}









