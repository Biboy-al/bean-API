package bean.api.beanCatalog.bean.services;

import bean.api.beanCatalog.bean.dto.BeanDTO;
import java.util.List;

public interface BeanQueryService {

  BeanDTO findById(long id);

  List<BeanDTO> findAll();
}
