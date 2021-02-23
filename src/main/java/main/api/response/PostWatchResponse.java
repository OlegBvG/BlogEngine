package main.api.response;

import java.util.List;
import java.util.Set;
import main.repositories.CommentsToWatch;
import main.repositories.UserToView;

public class PostWatchResponse {
  private int id;
  private long timestamp;
  private boolean active;
  private UserToView user;
  private String title;
  private String text;
  private int likeCount;
  private int dislikeCount;
  private int viewCount;
  private Set<CommentsToWatch> comments;
  private List<String> tags;

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

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public UserToView getUser() {
    return user;
  }

  public void setUser(UserToView user) {
    this.user = user;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  public int getDislikeCount() {
    return dislikeCount;
  }

  public void setDislikeCount(int dislikeCount) {
    this.dislikeCount = dislikeCount;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public Set<CommentsToWatch> getComments() {
    return comments;
  }

  public void setComments(Set<CommentsToWatch> comments) {
    this.comments = comments;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }
}
