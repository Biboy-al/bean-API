package bean.api.repos;

import bean.api.domain.Bean;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface BeanRepository extends CrudRepository<Bean, Long> {
  Optional<Bean> findById(long id);
}
