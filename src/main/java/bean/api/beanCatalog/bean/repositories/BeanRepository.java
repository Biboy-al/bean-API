package bean.api.beanCatalog.bean.repositories;

import bean.api.beanCatalog.bean.entites.Bean;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface BeanRepository extends CrudRepository<Bean, Long> {
  Optional<Bean> findById(long id);

  Optional<List<Bean>> findAllByOrderByIdDesc();
}
