package main.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; // id пользователя

  @Column(columnDefinition = "TINYINT")
  @NotNull
  private int is_moderator; //tinyint является ли пользователь модератором

  @Column
  @NotNull
  private java.sql.Timestamp reg_time; //DATETIME дата и время регистрации пользователя

  @Column
  @NotNull
  private String name; // имя пользователя

  @Column
  @NotNull
  private String email; // e-mail пользователя

  @Column

  @NotNull
  private String password; //хэш пароля пользователя

  private String code; //код для восстановления пароля, может быть NULL

  @Column(columnDefinition = "TEXT")
  private String photo;  //TEXT фотография (ссылка на файл), может быть NULL


  @OneToMany(mappedBy = "users")
  protected Set<Posts> posts = new HashSet<>();

  @OneToMany(mappedBy = "users")
  protected Set<PostVotes> postVotes = new HashSet<>();

  @OneToMany(mappedBy = "users")
  protected Set<PostComments> postComments = new HashSet<>();


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIs_moderator() {
    return is_moderator;
  }

  public void setIs_moderator(int is_moderator) {
    this.is_moderator = is_moderator;
  }

  public Timestamp getReg_time() {
    return reg_time;
  }

  public void setReg_time(Timestamp reg_time) {
    this.reg_time = reg_time;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }
}
