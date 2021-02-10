package main.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Entity
@Table(name = "global_settings")
public class GlobalSettings {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; // INT NOT NULL AUTO_INCREMENT id настройки

  @Column
  @NotNull
  private String code; //VARCHAR(255) NOT NULL системное имя настройки

  @Column
  @NotNull
  private String name; //VARCHAR(255) NOT NULL название настройки

  @Column
  @NotNull
  private String value; //VARCHAR(255) NOT NULL значение настройки

  /*
  @Query(value =
      "SELECT * FROM posts p WHERE is_active= :isActive AND moderation_status= :modStatus AND " +
          "time<= :date ORDER BY (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1)"
          +
          " DESC, (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1), p.time DESC",
      nativeQuery = true)
  List<Post> getBestPosts(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus,
      @Param("date") Date time,
      Pageable pageable);
   */
//    @Query("SELECT value FROM blog.global_settings gs WHERE gs.code=MULTIUSER_MODE")
  //  @Query("SELECT * FROM blog.global_settings gs ")
//  Collection<GlobalSettings> globalSettings() {
//  @Query(value = "SELECT value FROM blog.global_settings gs", nativeQuery = true)
//  List<GlobalSettings> globalSettings(@Param"MULTIUSER_MODE" boolean multiuserMode) ;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


}
