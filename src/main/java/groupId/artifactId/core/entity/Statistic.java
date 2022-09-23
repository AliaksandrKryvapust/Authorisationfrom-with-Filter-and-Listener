package groupId.artifactId.core.entity;

public class Statistic {
    private final Integer sessionCounter;
    private final Integer userCounter;
    private final Integer messagesCounter;

    public Statistic(Integer sessionCounter, int userCounter, int messagesCounter) {
        this.sessionCounter = sessionCounter;
        this.userCounter = userCounter;
        this.messagesCounter = messagesCounter;
    }

    public Integer getSessionCounter() {
        return sessionCounter;
    }

    public Integer getUserCounter() {
        return userCounter;
    }

    public Integer getMessagesCounter() {
        return messagesCounter;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "sessionCounter=" + sessionCounter +
                ", userCounter=" + userCounter +
                ", messagesCounter=" + messagesCounter +
                '}';
    }
}
