package main.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "post_comments")

public class PostComments {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; // INT NOT NULL  AUTO_INCREMENT  id комментария

  @Column(name = "parent_id")
//  @NotNull
//  @Null
  private int parentId;//INT   комментарий, на который оставлен этот комментарий (может быть NULL, если комментарий оставлен просто к посту)

  @Column(name = "post_id")
  @NotNull
  private int postId;//INT NOT NULL пост, к которому написан комментарий

  @Column(name = "user_id")
  @NotNull
  private int userId;//INT NOT NULL автор комментария

  @Column
  @NotNull
  private java.sql.Timestamp time; //DATETIME NOT  NULL  дата и время комментария

  @Column (columnDefinition = "TEXT")
  @NotNull
  private String text; //TEXT NOT NULL текст комментария

  @ManyToOne
  @JoinColumn(
      name = "user_id",
      insertable = false, updatable = false)
  private User user;

  @ManyToOne
  @JoinColumn(
      name = "post_id",
      insertable = false, updatable = false)
  private Post post;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }
//
//  public Post getPost() {
//    return post;
//  }
//
//  public void setPost(Post post) {
//    this.post = post;
//  }
}
