package bean.api.service;

import bean.api.beanCatalog.bean.dto.BeanDTO;
import bean.api.beanCatalog.bean.entites.Bean;
import bean.api.beanCatalog.bean.repositories.BeanRepository;
import bean.api.beanCatalog.bean.services.BeanQueryServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BeanQueryServiceTest {

  @Mock BeanRepository beanRepository;

  @Test
  public void testFetchAllBean() {
    Bean mockBean1 = new Bean("Supreme - Brazil", "Supreme Brazil is good");
    Bean mockBean2 = new Bean("Supreme - Decaf", "Supreme Decaf is bad");

    Mockito.when(beanRepository.findAllByOrderByIdDesc())
        .thenReturn(Optional.of(List.of(mockBean1, mockBean2)));

    BeanQueryServiceImpl service = new BeanQueryServiceImpl(beanRepository);

    List<BeanDTO> listOfBeans = service.findAll();

    Assertions.assertFalse(listOfBeans.isEmpty());
    Assertions.assertInstanceOf(List.class, listOfBeans);
    Assertions.assertInstanceOf(BeanDTO.class, listOfBeans.getFirst());
  }

  @Test
  public void testFetchBean() {

    Bean mockBean = new Bean("Supreme", "Supreme is good");
    mockBean.setId(1L);

    System.out.println(mockBean.getId());

    Mockito.when(beanRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(mockBean));

    BeanQueryServiceImpl service = new BeanQueryServiceImpl(beanRepository);

    BeanDTO bean = service.findById(1L);

    Assertions.assertNotNull(bean);
    Assertions.assertInstanceOf(BeanDTO.class, bean);
  }
}
