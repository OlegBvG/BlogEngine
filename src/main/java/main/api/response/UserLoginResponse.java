package main.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {
  private long id;
  private String name;
  private String photo;
  private String email;
  private boolean moderation;
  private int moderationCount;
  private boolean settings;

  @Autowired
  UserRepository userRepository;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoto() {
    return  photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isModeration() {
    return moderation;
  }

  public void setModeration(boolean moderation) {
    this.moderation = moderation;
  }

  public int getModerationCount() {
    return moderationCount;
  }

  public void setModerationCount(int moderationCount) {
    this.moderationCount = moderationCount;
  }

  public boolean isSettings() {
    return settings;
  }

  public void setSettings(boolean settings) {
    this.settings = settings;
  }
}
