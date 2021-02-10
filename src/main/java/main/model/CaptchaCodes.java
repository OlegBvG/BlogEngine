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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; // INT NOT NULL AUTO_INCREMENT id каптча

  @Column(nullable = false, columnDefinition = "DATETIME")
  @NotNull
  private java.sql.Timestamp time; //DATETIME NOT NULL дата и время генерации кода капчи

  @Column(nullable = false, columnDefinition = "TINYINT")
  @NotNull
  private int code;//TINYTEXT NOT NULL код, отображаемый на картинкке капчи

  @Column(nullable = false, columnDefinition = "TINYINT", name = "secret_code")
  @NotNull
  private int secretCode;//TINYTEXT NOT NULL код, передаваемый в параметре

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

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getSecretCode() {
    return secretCode;
  }

  public void setSecretCode(int secretCode) {
    this.secretCode = secretCode;
  }


}
