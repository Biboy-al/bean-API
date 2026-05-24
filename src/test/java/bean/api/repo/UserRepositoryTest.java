package bean.api.repo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import bean.api.identity.user.entites.User;
import bean.api.identity.user.repositories.UserRepository;
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
public class UserRepositoryTest {

  @Container @ServiceConnection
  static PostgreSQLContainer<?> postgreSQLContainer =
      new PostgreSQLContainer<>("postgres:16-alpine");

  @Autowired private UserRepository userRepository;

  @Test
  public void testSaveAndFindById() {
    User user = new User("username", "password");

    User savedUser = userRepository.save(user);
    Optional<User> optionalUser = userRepository.findById(savedUser.getId());

    assertTrue(optionalUser.isPresent());
  }

  @Test
  public void testSaveAndFindByUsername() {

    User user = new User("username", "password");

    User savedUser = userRepository.save(user);
    Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

    assertTrue(optionalUser.isPresent());
  }

  @Test
  public void testSaveANdFindByEmail() {

    User user = new User("David", "David.Sans@outlook.com");
    userRepository.save(user);
    Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

    assertTrue(optionalUser.isPresent());
  }

  @Test
  public void testSaveAndFailLoadByEmail() {
    User user = new User("David", "David.Sans@outlook.com");
    userRepository.save(user);
    Optional<User> optionalUser = userRepository.findByEmail("sans@outlook.com");

    assertTrue(optionalUser.isEmpty());
  }
}
