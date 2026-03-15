package bean.api;

import bean.api.domain.User;
import bean.api.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

  private static final Logger logger = LoggerFactory.getLogger(ApiApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(UserRepository repo) {

    return args -> {
      repo.save(new User("Johnssss", "Doesss"));

      repo.findAll().forEach(user -> logger.info("User: {}", user.getUsername()));

      repo.deleteAll();
    };
  }
}
