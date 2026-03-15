package bean.api.controller;

import bean.api.dto.BeanDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bean")
public class BeanController {

  @PostMapping
  public BeanDTO postBean() {

    return null;
  }

  @GetMapping("/{id}")
  public BeanDTO getBean(@PathVariable("id") String id) {
    return null;
  }
}
