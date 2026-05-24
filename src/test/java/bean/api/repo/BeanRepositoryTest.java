package bean.api.repo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import bean.api.beanCatalog.bean.entites.Bean;
import bean.api.beanCatalog.bean.repositories.BeanRepository;
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
public class BeanRepositoryTest {

  @Container @ServiceConnection
  static PostgreSQLContainer<?> postgreSQLContainer =
      new PostgreSQLContainer<>("postgres:16-alpine");

  @Autowired private BeanRepository beanRepository;

  @Test
  public void testSaveAndFindById() {
    Bean bean = new Bean("Supreme - Brazil", "Supreme Brazil is lightly roasted coffee bean");
    Bean savedBean = beanRepository.save(bean);
    Optional<Bean> optionalBean = beanRepository.findById(savedBean.getId());

    assertTrue(optionalBean.isPresent());
  }
}
