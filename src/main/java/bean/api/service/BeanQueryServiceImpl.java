package bean.api.service;

import bean.api.domain.Bean;
import bean.api.dto.BeanDTO;
import bean.api.repos.BeanRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BeanQueryServiceImpl implements BeanQueryService {

  private final BeanRepository beanRepository;

  public BeanQueryServiceImpl(BeanRepository beanRepository) {
    this.beanRepository = beanRepository;
  }

  @Override
  public BeanDTO findById(long id) {

    Optional<Bean> optionalBean = beanRepository.findById(id);

    if (optionalBean.isEmpty()) {
      return null;
    }

    Bean bean = optionalBean.get();

    return new BeanDTO(bean.getId(), bean.getName(), bean.getDescription(), List.of());
  }

  @Override
  public List<BeanDTO> findAll() {
    Optional<List<Bean>> optionalListBean = beanRepository.findAllByOrderByIdDesc();

    if (optionalListBean.isEmpty()) {
      return List.of();
    }

    List<Bean> beanList = optionalListBean.get();

    return beanList.stream()
        .map((bean -> new BeanDTO(bean.getId(), bean.getName(), bean.getDescription(), List.of())))
        .toList();
  }
}
