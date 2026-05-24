package bean.api.identity.user.dto;

import bean.api.review.review.dto.ReviewDTO;
import java.util.List;

public record UserDTO(
    long id, String username, String password, String email, List<ReviewDTO> reviews) {

  public UserDTO {
    reviews = List.copyOf(reviews);
  }
}
