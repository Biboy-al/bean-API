package bean.api.repo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import bean.api.review.review.entites.Review;
import bean.api.review.review.repositories.ReviewRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@Transactional
public class ReviewRepositoryTest {

  @Container @ServiceConnection
  static PostgreSQLContainer<?> postgreSQLContainer =
      new PostgreSQLContainer<>("postgres:16-alpine");

  @Autowired ReviewRepository reviewRepository;

  @Test
  public void testSaveAndFindById() {
    Review review = new Review(10, "Coffee Beans", 1L, 2L);

    Review savedReview = reviewRepository.save(review);

    Optional<Review> optionalReview = reviewRepository.findById(savedReview.getId());

    assertTrue(optionalReview.isPresent());
  }
}
