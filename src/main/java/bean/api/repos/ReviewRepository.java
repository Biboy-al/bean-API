package bean.api.repos;

import bean.api.domain.Review;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
  Optional<Review> findById(long id);
}
