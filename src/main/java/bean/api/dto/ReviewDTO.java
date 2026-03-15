package bean.api.dto;

public record ReviewDTO(long id, int rating, String comment, long userId, long reviewId) {}
