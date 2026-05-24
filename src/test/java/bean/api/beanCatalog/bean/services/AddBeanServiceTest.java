package bean.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import bean.api.beanCatalog.bean.dto.BeanDTO;
import bean.api.beanCatalog.bean.dto.CreateBeanRequest;
import bean.api.beanCatalog.bean.entites.Bean;
import bean.api.beanCatalog.bean.repositories.BeanRepository;
import bean.api.beanCatalog.bean.services.AddBeanServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddBeanServiceTest {

  @Mock private BeanRepository beanRepository;

  @Test
  public void testAddBean() {
    AddBeanServiceImpl service = new AddBeanServiceImpl(beanRepository);

    Bean mockBean = new Bean("Supreme", "Supreme is good");

    mockBean.setId(1L);

    when(beanRepository.save(any(Bean.class))).thenReturn(mockBean);

    BeanDTO createdBean =
        service.createBean(new CreateBeanRequest("David", "David.jams@gmail.com"));

    assertNotNull(createdBean);
    assertEquals(1L, createdBean.id());
  }
}
