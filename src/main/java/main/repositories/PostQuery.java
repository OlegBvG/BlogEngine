package main.repositories;

import main.model.Post;

public class PostQuery {

  private Post post;
  private String name;
  private String announce;
  private int likeCount;
  private int dislikeCount;
  private int commentCount;

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
}
