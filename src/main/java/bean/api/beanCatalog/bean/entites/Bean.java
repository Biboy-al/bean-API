package bean.api.beanCatalog.bean.entites;

import bean.api.shared.entites.IEntity;
import jakarta.persistence.*;

@Entity
public class Bean implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private final String name;

  private final String description;

  //   protected Bean() {}

  public Bean(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }
}
