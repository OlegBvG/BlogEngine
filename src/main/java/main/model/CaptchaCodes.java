package main.model;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "captcha_codes")
public class CaptchaCodes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id; // INT NOT NULL AUTO_INCREMENT id каптча

  @Column(nullable = false, columnDefinition = "DATETIME")
  @NotNull
  private java.sql.Timestamp time; //DATETIME NOT NULL дата и время генерации кода капчи

  @Column(nullable = false, columnDefinition = "TINYTEXT")
  private @NotNull String code;//TINYTEXT NOT NULL код, отображаемый на картинкке капчи

  @Column(nullable = false, columnDefinition = "TINYTEXT", name = "secret_code")
  private @NotNull String secretCode;//TINYTEXT NOT NULL код, передаваемый в параметре

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public @NotNull String getCode() {
    return code;
  }

  public void setCode(@NotNull String code) {
    this.code = code;
  }

  public @NotNull String getSecretCode() {
    return secretCode;
  }

  public void setSecretCode(@NotNull String secretCode) {
    this.secretCode = secretCode;
  }

  public CaptchaCodes() {

  }
}
