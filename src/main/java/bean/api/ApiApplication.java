package bean.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

  //  private static final Logger logger = LoggerFactory.getLogger(ApiApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }

  //  @Bean
  //  public CommandLineRunner demo(UserRepository repo) {
  //
  //    return args -> {
  //      repo.save(new User("Johnssss", "Doesss"));
  //
  //      repo.findAll().forEach(user -> logger.info("User: {}", user.getUsername()));
  //
  //      repo.deleteAll();
  //    };
  //  }
}
