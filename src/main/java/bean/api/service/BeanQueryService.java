package bean.api.service;

import bean.api.dto.BeanDTO;
import java.util.List;

public interface BeanQueryService {

  BeanDTO findById(long id);

  List<BeanDTO> findAll();
}
