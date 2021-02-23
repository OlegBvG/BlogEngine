package main.repositories;

import main.model.User;

public class UserToWatch {
  private int id;
  private String name;
  private String photo;

  public UserToWatch(int id, String name, String photo) {
    this.id = id;
    this.name = name;
    this.photo = photo;
  }

  public UserToWatch(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.photo = user.getPhoto();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }
}
