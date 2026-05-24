package bean.api.beanCatalog.bean.dto;

import bean.api.review.review.dto.ReviewDTO;
import java.util.List;

public record BeanDTO(long id, String name, String description, List<ReviewDTO> reviews) {

  public BeanDTO {
    reviews = List.copyOf(reviews);
  }
}
