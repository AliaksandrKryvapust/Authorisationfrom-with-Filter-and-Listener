package groupId.artifactId.storage.api;

import java.util.List;
import java.util.Optional;

public interface IEssenceStorage<TYPE> {
    List<TYPE> get();

    Optional<TYPE> getByLogin(String login);
}
