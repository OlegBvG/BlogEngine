package main.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; // INT NOT NULL AUTO_INCREMENT id поста

  @Column(name="is_active", columnDefinition = "TINYINT")
  @NotNull
  private int isActive;//TINYINT NOT NULL скрыта или активна публикация: 0 или 1
//  private int is_active;//TINYINT NOT NULL скрыта или активна публикация: 0 или 1
/*
@Column(name =  "price_per_hour")
    private float pricePerHour;
 */
  @Enumerated(EnumType.STRING)
  @Column(name="moderation_status", columnDefinition = "ENUM('NEW', 'ACCEPTED', 'DECLINED')")
  @NotNull
  private ModerationStatus moderationStatus; //ENUM("NEW", "ACCEPTED", "DECLINED") NOT NULL статус модерации, по умолчанию значение "NEW".

  @Column
  private int moderator_id; // INT  ID пользователя-модератора,  принявшего решение, или NULL

  @Column
  @NotNull
  private int user_id; //INT NOT NULL автор поста

  @Column
  @NotNull
  private java.sql.Timestamp time; //DATETIME NOT NULL дата и время публикации поста

  @Column
  @NotNull
  private String title; //VARCHAR(255) NOT NULL заголовок поста

  @Column (columnDefinition = "TEXT")
  @NotNull
  private String text; //TEXT NOT NULL текст поста

  @Column
  @NotNull
  private int view_count; //INT NOT NULL количество просмотров поста


  @ManyToOne
  @JoinColumn(
      name = "user_id",
      insertable = false, updatable = false)
  private User user;

  @ManyToOne
  @JoinColumn(
      name = "moderator_id",
      insertable = false, updatable = false)
  private UsersModerator usersModerator;

  @OneToMany(mappedBy = "post")
  private Set<PostVotes> postVotes = new HashSet<>();

  @OneToMany(mappedBy = "post")
  private Set<PostComments> postComments = new HashSet<>();


  @ManyToMany
  @JoinTable(
//      name = "TagToPost",
      name = "tag2post",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
  Set<Tags> postTags;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIsActive() {
    return isActive;
  }

  public void setIsActive(int isActive) {
    this.isActive = isActive;
  }

  public ModerationStatus getModerationStatus() {
    return moderationStatus;
  }

  public void setModerationStatus(ModerationStatus moderationStatus) {
    this.moderationStatus = moderationStatus;
  }

  public int getModerator_id() {
    return moderator_id;
  }

  public void setModerator_id(int moderator_id) {
    this.moderator_id = moderator_id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
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

  public int getView_count() {
    return view_count;
  }

  public void setView_count(int view_count) {
    this.view_count = view_count;
  }

  public User getUser() {
    return user;
  }

//  public UsersModerator getUsersModerator() {
//    return usersModerator;
//  }
//
  public Set<PostVotes> getPostVotes() {
    return postVotes;
  }

  public Set<PostComments> getPostComments() {
    return postComments;
  }

//  public Set<Tags> getPostTags() {
//    return postTags;
//  }
}
