package bean.api.beanCatalog.bean.services;

import bean.api.beanCatalog.bean.dto.BeanDTO;
import bean.api.beanCatalog.bean.dto.CreateBeanRequest;

public interface AddBeanService {
  public BeanDTO createBean(CreateBeanRequest createBeanRequest);
}
