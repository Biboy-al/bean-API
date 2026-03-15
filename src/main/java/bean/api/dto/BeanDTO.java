package bean.api.dto;

import bean.api.domain.Review;
import java.util.List;

public record BeanDTO(long id, String name, String description, List<Review> reviews) {}
