package main.model;

import javax.persistence.Entity;
import javax.persistence.Id;


  @Entity
  @org.hibernate.annotations.Immutable
  @org.hibernate.annotations.Subselect( value = "SELECT id, name FROM blog.users where is_moderator = 1 ")
  @org.hibernate.annotations.Synchronize({"Users"})
  public class UsersModerator {
    @Id
    private int Id;
    private String name;

    public UsersModerator() {
    }

    public int getId() {
      return Id;
    }

    public void setId(int id) {
      Id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
