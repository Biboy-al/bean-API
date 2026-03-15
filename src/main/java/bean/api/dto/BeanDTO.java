package bean.api.dto;

import java.util.List;

public record BeanDTO(long id, String name, String description, List<ReviewDTO> reviews) {

  public BeanDTO {
    reviews = List.copyOf(reviews);
  }
}
