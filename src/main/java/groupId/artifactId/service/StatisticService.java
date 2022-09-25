package groupId.artifactId.service;

import groupId.artifactId.core.entity.Statistic;
import groupId.artifactId.service.api.IMessageService;
import groupId.artifactId.service.api.IStatisticService;
import groupId.artifactId.service.api.IUserService;

import java.util.concurrent.atomic.AtomicInteger;

public class StatisticService implements IStatisticService {

    private static StatisticService firstInstance = null;
    private static final AtomicInteger sessionCounter = new AtomicInteger(0);
    private final IMessageService service;
    private final IUserService userService;

    private StatisticService() {
        this.service = MessageService.getInstance();
        this.userService = UserService.getInstance();
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
        return new Statistic(sessionCounter.get(), userService.getSize(), service.getSize());
    }
}









