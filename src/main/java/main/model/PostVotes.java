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

@Entity
@Table(name = "post_votes")

public class PostVotes {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; // INT NOT NULL AUTO_INCREMENT id лайка/дизлайка

  @Column(name = "user_id")
  @NotNull
  private int userIid;//INT NOT NULL тот, кто поставил лайк / дизлайк

  @Column(name = "post_id")
  @NotNull
  private int postId; //INT NOT NULL пост, которому поставлен лайк / дизлайк

  @Column(nullable = false, columnDefinition = "DATETIME")
  @NotNull
  private java.sql.Timestamp time; //DATETIME NOT NULL дата и время лайка / дизлайка

  @Column(nullable = false, columnDefinition = "TINYINT")
//  @NotNull
  private int value;//TINYINT NOT NULL лайк или дизлайк: 1 или -1

  @ManyToOne
  @JoinColumn(
      name = "user_id",
      insertable = false, updatable = false)
  protected Users users;

  @ManyToOne
  @JoinColumn(
      name = "post_id",
      insertable = false, updatable = false)
  protected Posts posts;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserIid() {
    return userIid;
  }

  public void setUserIid(int userIid) {
    this.userIid = userIid;
  }

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
