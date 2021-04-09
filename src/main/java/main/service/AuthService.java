package main.service;

import com.github.cage.Cage;
import com.github.cage.image.Painter;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import main.api.response.LoginResponse;
import main.api.response.RegistrationResponse;
import main.api.response.UserLoginResponse;
import main.model.User;
import main.repositories.CaptchaRepository;
import main.repositories.PostRepository;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@Service
public class AuthService {

  @Autowired
  public UserRepository userRepository;

  @Autowired
  public CaptchaRepository captchaRepository;

  @Autowired
  public PostRepository postRepository;

  @Autowired
  public SettingsService settingsService;

  @Transactional
  public String checkEmailForRestore(Map<String, String> allParams) {

    String emailTo = allParams.get("email");
    String code = "";
    Optional<User> user = userRepository.findByEmail(emailTo);
    if (user.isPresent()) {
      code = randomLine(45);
      user.get().setCode(code);
      code = "/login/change-password/".concat(code);
    }

    return code;
  }

  public String randomLine(int length) {
    Random r = new Random();
    String code = r.ints(48, 122)
        .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
        .mapToObj(i -> (char) i)
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
        .toString();

    return code;
  }

  public Map<String, String> getCaptcha() throws IOException {
    Map<String, String> captcha = new HashMap<>();

    Cage cage = new Cage(
        new Painter(100, 35, null, null, null, null)
        , null, null, null, null, null, null);

    String tokenGenerator = cage.getTokenGenerator().next();
    System.out.println("tokenGenerator -----------------------" + tokenGenerator);

    String encodedString = Base64.getEncoder().encodeToString(cage.draw(tokenGenerator));
    String secretCode = randomLine(22);

    captchaRepository.deleteOverdueCaptcha();
    captchaRepository.addCaptcha(tokenGenerator, secretCode);

    captcha.put("image", "data:image/png;base64, " + encodedString);
    captcha.put("secret", secretCode);

    return captcha;
  }


  public ResponseEntity<?> checkRegistrationData(Map<String, String> allParams) {

    if (!settingsService.getGlobalSettings().isStatisticsIsPublic()) {
      return new ResponseEntity<>(HttpStatus.valueOf(404));
    }

    String e_mail = allParams.get("e_mail");
    String password = allParams.get("password");
    String name = allParams.get("name");
    String captcha = allParams.get("captcha");
    String captcha_secret = allParams.get("captcha_secret");

    Map<String, String> errors = new HashMap<String, String>();

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    Optional<User> user = userRepository.findByEmail(e_mail);
    if (user.isPresent()) {
      errors.put("email", "Этот email  уже зарегистрирован");
    }

    if (name.trim().length() < 2) {
      errors.put("name", "Имя указано неверно");
    }

    if (password.trim().length() < 6) {
      errors.put("password", "Пароль короче 6-ти символов");
    }

    if (!captchaRepository.getCaptchaBySecretCode(captcha_secret).getCode().equals(captcha)) {
      errors.put("captcha", "Код с картинки введён неверно");
    }

    RegistrationResponse registrationResponse = new RegistrationResponse();

    if (errors.isEmpty()) {

      if (userRepository.addUser(e_mail, name, passwordEncoder.encode(password)) == 1) {
        registrationResponse.setResult(true);
      }

    } else {
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);
    }

    return ResponseEntity.ok(registrationResponse);
  }

  public RegistrationResponse checkChangePassword(Map<String, String> allParams) {
    String code = allParams.get("code");
    String password = allParams.get("password");
    String captcha = allParams.get("captcha");
    String captcha_secret = allParams.get("captcha_secret");

    Map<String, String> errors = new HashMap<String, String>();

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    if (password.trim().length() < 6) {
      errors.put("password", "Пароль короче 6-ти символов");
    }

    if (!captchaRepository.getCaptchaBySecretCode(captcha_secret).getCode().equals(captcha)) {
      errors.put("captcha", "Код с картинки введён неверно");
    }

    RegistrationResponse registrationResponse = new RegistrationResponse();

    if (errors.isEmpty()) {

      Optional<User> userFind = userRepository.findByCode(code);
      if (userFind.isPresent()) {
        userFind.get().setPassword(passwordEncoder.encode(password));
        userRepository.save(userFind.get());
        registrationResponse.setResult(true);
      } else {
        errors.put("code", "Ссылка для восстановления пароля устарела."
            + "<a href=\"/login/restore-password\">Запросить ссылку снова</a>");
//            + "<a href=\"/auth/restore\">Запросить ссылку снова</a>");
        registrationResponse.setResult(false);
        registrationResponse.setErrors(errors);
      }

    } else {
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);
    }

    return registrationResponse;
  }


  public LoginResponse getLoginResponse(String email) {
    main.model.User currentUser =
        userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(email));

    UserLoginResponse userResponse = new UserLoginResponse();
    userResponse.setEmail(currentUser.getEmail());
    userResponse.setName(currentUser.getName());
    userResponse.setPhoto(currentUser.getPhoto());
    userResponse.setModeration(currentUser.getIs_moderator() == 1);
    userResponse.setSettings(currentUser.getIs_moderator() == 1);
    userResponse.setId(currentUser.getId());
    userResponse.setModerationCount(
        currentUser.getIs_moderator() == 1 ? postRepository.moderationCount() : 0);

    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setResult(true);
    loginResponse.setUserLoginResponse(userResponse);

    return loginResponse;
  }


  public int getCurrentUserId() {
    org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
        .getContext().getAuthentication().getPrincipal();
    main.model.User currentUser =
        userRepository.findByEmail(user.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));
    return currentUser.getId();
  }


  public boolean isCurrentUserAuthenticated() {

    return !SecurityContextHolder
        .getContext().getAuthentication().getPrincipal().equals("anonymousUser");
  }

  public boolean isCurrentUserModerator() {

    return SecurityContextHolder
        .getContext().getAuthentication().getAuthorities().toString().contains("moderate");
  }

  public boolean checkCaptcha(String captcha, String captcha_secret) {

    return captchaRepository.getCaptchaBySecretCode(captcha_secret).getCode().equals(captcha);
  }


  @Value("${someParameter.dstFolder}")
  String dstFolder;

  public RegistrationResponse updateProfile(
      MultipartFile photo, Integer removePhoto, String name, String email, String password) {

    Map<String, String> errors = new HashMap<String, String>();
    RegistrationResponse registrationResponse = new RegistrationResponse();
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    String fileName = "image Id " + getCurrentUserId() + ".jpg";

    String newFile = ImageService.imageResize(photo, dstFolder, fileName);
    User profileUser = userRepository.findById(getCurrentUserId()).get();
    profileUser.setPhoto(newFile);

    if (!profileUser.getName().trim().equals(name.trim())) {
      if (name.trim().length() < 2) {
        errors.put("name", "Имя указано неверно");
      } else {
        profileUser.setName(name);
      }
    }

    if (!profileUser.getEmail().trim().equals(email.trim())) {
      if (userRepository.findByEmail(email).isPresent()) {
        errors.put("email", "Этот e-mail уже зарегистрирован");
      } else {
        profileUser.setEmail(email);
      }
    }

    if (password != null) {
      if (password.trim().length() < 6) {
        errors.put("password", "Пароль короче 6-ти символов");
      } else {
        profileUser.setPassword(passwordEncoder.encode(password));
      }
    }

    if (errors.isEmpty()) {
      registrationResponse.setResult(true);
    } else {
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);
    }

    userRepository.saveAndFlush(profileUser);

    return registrationResponse;
  }

  public RegistrationResponse updateProfile(
      Integer removePhoto, String name, String email, String password) {

    Map<String, String> errors = new HashMap<String, String>();
    RegistrationResponse registrationResponse = new RegistrationResponse();
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    User profileUser = userRepository.findById(getCurrentUserId()).get();
    if (removePhoto == 1) {
      String fileName = "image Id " + getCurrentUserId() + ".jpg";

      String deleteFile = ImageService.imageDelete(dstFolder, fileName);
      profileUser.setPhoto(deleteFile);
    }

    if (!profileUser.getName().trim().equals(name.trim())) {
      if (name.trim().length() < 2) {
        errors.put("name", "Имя указано неверно");
      } else {
        profileUser.setName(name);
      }
    }

    if (!(profileUser.getEmail().trim()).equals(email.trim())) {
      if (userRepository.findByEmail(email).isPresent()) {
        errors.put("email", "Этот e-mail уже зарегистрирован");
      } else {
        profileUser.setEmail(email);
      }
    }

    if (password != null) {
      if (password.trim().length() < 6) {
        errors.put("password", "Пароль короче 6-ти символов");
      } else {
        profileUser.setPassword(passwordEncoder.encode(password));
      }
    }

    if (errors.isEmpty()) {
      registrationResponse.setResult(true);
    } else {
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);
    }

    userRepository.saveAndFlush(profileUser);

    return registrationResponse;
  }


}
