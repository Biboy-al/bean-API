package bean.api.controller;

import bean.api.dto.BeanDTO;
import bean.api.service.BeanQueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bean")
public class BeanController {

  private final BeanQueryService beanQueryService;

  public BeanController(BeanQueryService beanQueryService) {
    this.beanQueryService = beanQueryService;
  }


  @PostMapping
  public BeanDTO postBean() {

    return null;
  }

  @GetMapping("/{id}")
  public BeanDTO getBean(@PathVariable("id") String id) {

    long longId = Long.parseLong(id);

    return this.beanQueryService.findById(longId);
  }
}
