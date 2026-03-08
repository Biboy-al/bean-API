package bean.api.repos;

import bean.api.domain.Bean;
import org.springframework.data.repository.CrudRepository;

public interface BeanRepository extends CrudRepository<Bean, Long> {}
