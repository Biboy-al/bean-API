package bean.api.review.review.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import bean.api.review.review.entites.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
  Optional<Review> findById(long id);
}
