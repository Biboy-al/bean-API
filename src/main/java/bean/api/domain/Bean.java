package bean.api.domain;

import jakarta.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Bean implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  @OneToMany(mappedBy = "bean")
  private List<Review> reviews;

  protected Bean() {}

  public Bean(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

  public List<Review> getReviews() {
    return Collections.unmodifiableList(this.reviews);
  }
}
