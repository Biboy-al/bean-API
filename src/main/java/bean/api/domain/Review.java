package bean.api.domain;

import jakarta.persistence.*;
import org.apache.logging.log4j.internal.annotation.SuppressFBWarnings;

@Entity
public class Review implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int rating;

  private String comment;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "bean_id")
  private Bean bean;

  protected Review() {}

  public Review(int rating, String comment) {
    this.rating = rating;
    this.comment = comment;
    //    this.user = user;
    //    this.bean = bean;
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

  public User getUser() {
    return this.user;
  }

  @SuppressFBWarnings("EI_EXPOSE_REP")
  public Bean getBean() {
    return this.bean;
  }
}
