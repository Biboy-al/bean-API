package bean.api.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bean.api.domain.User;
import bean.api.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class UserRepositoryTest {

  @Container @ServiceConnection
  static PostgreSQLContainer<?> postgreSQLContainer =
      new PostgreSQLContainer<>("postgres:16-alpine");

  @Autowired private UserRepository userRepository;

  @Test
  public void testSave() {

    User user = new User("username", "password");

    User savedUser = userRepository.save(user);
    User foundUser = userRepository.findByUsername(user.getUsername());

    assertEquals(savedUser.getUsername(), foundUser.getUsername());
  }
}
