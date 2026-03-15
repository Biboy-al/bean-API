package bean.api.dto;

import bean.api.domain.Review;
import java.util.List;

public record UserDTO(
    long id, String username, String password, String email, List<Review> reviews) {}
