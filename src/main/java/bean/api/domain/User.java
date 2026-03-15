package bean.api.domain;

import jakarta.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "app_users")
public class User implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @OneToMany(mappedBy = "user")
  private List<Review> reviews;

  protected User() {}

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }

  @Override
  public long getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public String getEmail() {
    return this.email;
  }

  public List<Review> getReviews() {
    return Collections.unmodifiableList(this.reviews);
  }
}
