package bean.api.repos;

import bean.api.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);

  User findByEmail(String email);
}
