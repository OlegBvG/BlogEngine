package main.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tags")
public class Tags {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id; // INT NOT NULL AUTO_INCREMENT id тэга

  @Column
  @NotNull
  private String name;//VARCHAR(255) NOT NULL текст тэга


  @OneToMany(mappedBy = "tags")
  protected Set<TagToPost> tagToPosts = new HashSet<>();

//   @ManyToMany(mappedBy = "TagToPost")
   @ManyToMany(mappedBy = "postTags")
  Set<Post> tagPosts;

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

  public Set<Post> getTagPosts() {
    return tagPosts;
  }

  public void setTagPosts(Set<Post> tagPosts) {
    this.tagPosts = tagPosts;
  }
}
