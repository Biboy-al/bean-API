package bean.api.beanCatalog.bean.services;

import bean.api.beanCatalog.bean.dto.BeanDTO;
import bean.api.beanCatalog.bean.dto.CreateBeanRequest;
import bean.api.beanCatalog.bean.entites.Bean;
import bean.api.beanCatalog.bean.repositories.BeanRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AddBeanServiceImpl implements AddBeanService {

  private final BeanRepository beanRepository;

  public AddBeanServiceImpl(BeanRepository beanRepository) {
    this.beanRepository = beanRepository;
  }

  public BeanDTO createBean(CreateBeanRequest createBeanRequest) {

    Bean bean = new Bean("Supreme", "Supreme is good");

    Bean savedBean = beanRepository.save(bean);

    return new BeanDTO(
        savedBean.getId(), savedBean.getName(), savedBean.getDescription(), List.of());
  }
}
