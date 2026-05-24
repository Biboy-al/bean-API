package bean.api.review.review.repositories;

import bean.api.review.review.entites.Review;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
  Optional<Review> findById(long id);
}
