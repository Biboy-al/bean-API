package bean.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import bean.api.beanCatalog.bean.controller.BeanController;
import bean.api.beanCatalog.bean.dto.BeanDTO;
import bean.api.beanCatalog.bean.dto.CreateBeanRequest;
import bean.api.beanCatalog.bean.services.AddBeanServiceImpl;
import bean.api.beanCatalog.bean.services.BeanQueryServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

@WebMvcTest(BeanController.class)
@AutoConfigureRestTestClient
public class BeanControllerTest {

  @Autowired private RestTestClient restTestClient;

  @MockitoBean private BeanQueryServiceImpl queryService;

  @MockitoBean private AddBeanServiceImpl addService;

  @Test
  public void testAddBean() {

    when(addService.createBean(any(CreateBeanRequest.class)))
        .thenReturn(new BeanDTO(1L, "Supreme Brazil", "Tastes very good", List.of()));

    restTestClient
        .post()
        .uri("/bean")
        .body(new CreateBeanRequest("Supreme", "Supreme is good"))
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  public void testGETEndpointById() {

    BeanDTO mockBeanDTO = new BeanDTO(1L, "Supreme Brazil", "Tastes very good", List.of());

    when(queryService.findById(1L)).thenReturn(mockBeanDTO);

    restTestClient.get().uri("/bean/{id}", 1L).exchange().expectStatus().isOk();
  }
}
