package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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



}
