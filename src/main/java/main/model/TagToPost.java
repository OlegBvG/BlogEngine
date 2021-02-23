package main.model;

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
@Table(name = "tag2post")

public class TagToPost {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; // INT NOT NULL AUTO_INCREMENT id связи

  @Column(name = "post_id")
  @NotNull
  private int postId;//INT NOT NULL id поста

  @Column(name = "tag_id")
  @NotNull
  private int tagId; //INT NOT NULL id тэга

  @ManyToOne
  @JoinColumn(
      name = "tag_id",
      insertable = false, updatable = false)
  protected Tags tags;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public int getTagId() {
    return tagId;
  }

  public void setTagId(int tagId) {
    this.tagId = tagId;
  }
}
