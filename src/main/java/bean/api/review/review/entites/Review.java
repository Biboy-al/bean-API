package bean.api.review.review.entites;

import bean.api.shared.entites.IEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int rating;

  private String comment;

  private long userId;

  private long beanId;

  protected Review() {}

  public Review(int rating, String comment, long userId, long beanId) {
    this.rating = rating;
    this.comment = comment;
    this.userId = userId;
    this.beanId = beanId;
  }

  @Override
  public long getId() {
    return this.id;
  }

  public int getRating() {
    return this.rating;
  }

  public String getComment() {
    return this.comment;
  }
}
