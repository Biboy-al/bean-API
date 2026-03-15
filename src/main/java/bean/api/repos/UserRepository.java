package bean.api.repos;

import bean.api.domain.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findById(long id);

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);
}
