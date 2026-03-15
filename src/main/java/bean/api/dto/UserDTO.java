package bean.api.dto;

import java.util.List;

public record UserDTO(
    long id, String username, String password, String email, List<ReviewDTO> reviews) {

  public UserDTO {
    reviews = List.copyOf(reviews);
  }
}
