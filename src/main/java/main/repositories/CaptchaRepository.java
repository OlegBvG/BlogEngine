package main.repositories;

import main.model.CaptchaCodes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

@Transactional
public interface CaptchaRepository extends CrudRepository<CaptchaCodes, Long> {

  CaptchaCodes save(CaptchaCodes captchaCodes);

  @Modifying
  @Query(value =
      "INSERT INTO captcha_codes (code, secret_code, time) "
          + "VALUES (:code, :secret_code, now())",
      nativeQuery = true)
  void addCaptcha(@Param("code") String code,
      @Param("secret_code") String secretCode);


  @Modifying
  @Query(value = "delete from captcha_codes where TIMESTAMPDIFF(MINUTE, time, now()) > 60 ",
      nativeQuery = true)
  void deleteOverdueCaptcha();


  //-----------Получение каптчи----------------
  @Query(value =
      "SELECT * FROM captcha_codes where STRCMP(secret_code, :secretCode)=0",
      nativeQuery = true)
  CaptchaCodes getCaptchaBySecretCode(@Param("secretCode") String secretCode);

}
