package bean.api.service;

import bean.api.repos.BeanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class TestAddBeanService {

  @MockitoBean private BeanRepository beanRepository;

  @Test
  public void testAddBean() {

    //        AddBeanServiceImpl service = new AddBeanServiceImpl();
  }
}
