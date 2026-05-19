package bean.api.controller;

import bean.api.dto.BeanDTO;
import bean.api.dto.CreateBeanRequest;
import bean.api.service.AddBeanService;
import bean.api.service.BeanQueryService;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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