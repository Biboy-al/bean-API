package bean.api.service;

import bean.api.dto.BeanDTO;
import bean.api.dto.CreateBeanRequest;

public interface AddBeanService {
  public BeanDTO createBean(CreateBeanRequest createBeanRequest);
}
