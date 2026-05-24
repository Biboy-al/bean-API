package bean.api.service;

import bean.api.domain.Bean;
import bean.api.dto.BeanDTO;
import bean.api.dto.CreateBeanRequest;
import bean.api.repos.BeanRepository;
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
