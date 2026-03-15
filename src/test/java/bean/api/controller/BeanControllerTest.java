package bean.api.controller;

import bean.api.domain.Bean;
import bean.api.dto.BeanDTO;
import bean.api.service.BeanQueryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(BeanController.class)
@AutoConfigureRestTestClient
public class BeanControllerTest {

    @Autowired
    private RestTestClient restTestClient;

    @MockitoBean private BeanQueryServiceImpl service;

    @Test
    public void testGETEndpointById(){

        BeanDTO mockBeanDTO = new BeanDTO(1L, "Supreme Brazil", "Tastes very good", List.of());

        when(service.findById(1L))
                .thenReturn(mockBeanDTO);

        restTestClient.get()
                .uri("/bean/{id}", 1L)
                .exchange()
                .expectStatus().isOk();
    }
}
