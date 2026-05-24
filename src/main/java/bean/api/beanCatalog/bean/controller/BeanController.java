package bean.api.beanCatalog.bean.controller;

import bean.api.beanCatalog.bean.dto.BeanDTO;
import bean.api.beanCatalog.bean.dto.CreateBeanRequest;
import bean.api.beanCatalog.bean.services.AddBeanService;
import bean.api.beanCatalog.bean.services.BeanQueryService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class BeanController {

  private final BeanQueryService beanQueryService;
  private final AddBeanService addBeanService;

  public BeanController(BeanQueryService beanQueryService, AddBeanService addBeanService) {
    this.beanQueryService = beanQueryService;
    this.addBeanService = addBeanService;
  }

  @PostMapping
  public BeanDTO postBean(@RequestBody CreateBeanRequest createBeanRequest) {
    return this.addBeanService.createBean(createBeanRequest);
  }

  @GetMapping
  public List<BeanDTO> getAllBean(@RequestParam String param) {
    return this.beanQueryService.findAll();
  }

  @GetMapping("/{id}")
  public BeanDTO getBeanById(@PathVariable("id") String id) {

    long longId = Long.parseLong(id);

    return this.beanQueryService.findById(longId);
  }
}
