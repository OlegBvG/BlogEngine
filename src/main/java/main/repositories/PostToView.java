package main.repositories;

public class PostToView  {
  private int id;
  private long timestamp;
  private UserToView user;
  private String title;
  private String announce;
  private int likeCount;
  private int dislikeCount;
  private int commentCount;
  private int viewCount;

  public PostToView(int id, long timestamp, UserToView user, String title, String announce,
      int likeCount, int dislikeCount, int commentCount, int viewCount) {
    this.id = id;
    this.timestamp = timestamp;
    this.user = user;
    this.title = title;
    this.announce = announce;
    this.likeCount = likeCount;
    this.dislikeCount = dislikeCount;
    this.commentCount = commentCount;
    this.viewCount = viewCount;
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

  public String getAnnounce() {
    return announce;
  }

  public void setAnnounce(String announce) {
    this.announce = announce;
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

  public int getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }


}
