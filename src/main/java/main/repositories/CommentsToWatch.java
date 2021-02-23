package main.repositories;

import main.model.PostComments;

public class
CommentsToWatch {

  private int id;
  private long timestamp;
  private String text;
  private UserToWatch user;

  public CommentsToWatch(PostComments postComments) {
    this.id = postComments.getId();
    this.timestamp = postComments.getTime().getTime() / 1000;
    this.user = new UserToWatch(postComments.getUser());
    this.text = postComments.getText();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public UserToWatch getUser() {
    return user;
  }

  public void setUser(UserToWatch user) {
    this.user = user;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
