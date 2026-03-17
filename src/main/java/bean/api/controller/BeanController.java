package bean.api.controller;

import bean.api.dto.BeanDTO;
import bean.api.dto.CreateBeanRequest;
import bean.api.service.AddBeanService;
import bean.api.service.BeanQueryService;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public BeanDTO getBean(@PathVariable("id") String id) {

    long longId = Long.parseLong(id);

    return this.beanQueryService.findById(longId);
  }
}
