package bean.api.domain;

import jakarta.persistence.*;

@Entity
public class Review implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private int rating;

  private String comment;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "bean_id")
  private Bean bean;

  protected Review() {}

  public Review(int rating, String comment, User user, Bean bean) {
    this.rating = rating;
    this.comment = comment;
    this.user = user;
    this.bean = bean;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public int getRating() {
    return this.rating;
  }

  public String getComment() {
    return this.comment;
  }

  public User getUser() {
    return this.user;
  }

  public Bean getBean() {
    return this.bean;
  }
}
