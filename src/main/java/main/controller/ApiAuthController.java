package main.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import javax.validation.Valid;
import main.api.request.LoginRequest;
import main.api.request.ProfileRequest;
import main.api.response.LoginResponse;
import main.api.response.RegistrationResponse;
import main.api.response.RestorationPasswordResponse;
import main.repositories.UserRepository;
import main.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ApiAuthController {

  private AuthService authService;

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;

  @Value("${blog.email}")
  private String emailFrom;

  @Autowired
  public ApiAuthController(
      AuthService authService, AuthenticationManager authenticationManager,
      UserRepository userRepository) {
    this.authService = authService;
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
  }

  @PostMapping("/auth/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    Authentication auth = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(auth);
    User user = (User) auth.getPrincipal();

    return ResponseEntity.ok(authService.getLoginResponse(user.getUsername()));

  }

  @GetMapping("/auth/logout")
  public ResponseEntity<?> logout() {

    SecurityContextHolder.clearContext();
    RegistrationResponse registrationResponse = new RegistrationResponse();
    registrationResponse.setResult(true);

    return ResponseEntity.ok(registrationResponse);
  }


  @GetMapping("/auth/check")
  public ResponseEntity<LoginResponse> check(Principal principal) {
    if (principal == null) {
      return ResponseEntity.ok(new LoginResponse());
    }

    return ResponseEntity.ok(authService.getLoginResponse(principal.getName()));
  }


  @Autowired
  public JavaMailSender emailSender;

  @ResponseBody
  @PostMapping("/auth/restore")

  public RestorationPasswordResponse sendRestorePassword(
      @RequestBody Map<String, String> allParams) {

    String restoreLink = authService.checkEmailForRestore(allParams);
    boolean result = false;

    if (restoreLink.length() > 0) {
      String emailTo = allParams.get("email");
      SimpleMailMessage message = new SimpleMailMessage();

      message.setTo(emailTo);
      message.setFrom(emailFrom);
      message.setSubject("Восстановление пароля");
      message.setText(restoreLink);

      try {
        this.emailSender.send(message);
        result = true;
      } catch (final MailSendException e) {
        System.out.println(" Ошибка отправки сообщения ---> " + e);
      }
    }

    RestorationPasswordResponse restorationPasswordResponse = new RestorationPasswordResponse();
    restorationPasswordResponse.setResult(result);

    return restorationPasswordResponse;
  }


  @GetMapping("/auth/captcha")
  public Map<String, String> captcha() throws IOException {
    return authService.getCaptcha();
  }

  @ResponseBody
  @PostMapping("/auth/register")

  public ResponseEntity<?> registration(@RequestBody Map<String, String> allParams) {

    return authService.checkRegistrationData(allParams);
  }

  @ResponseBody
  @PostMapping("/auth/password")

  public RegistrationResponse changePassword(@RequestBody Map<String, String> allParams) {
    return authService.checkChangePassword(allParams);
  }

  @PostMapping(value = "/profile/my"
      , consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateProfileWithPhoto(
      @RequestParam("photo") MultipartFile photo,
      @RequestParam("removePhoto") Integer removePhoto,
      @RequestParam("name") String name,
      @RequestParam("email") String email,
      @RequestParam(name = "password", required = false) String password
  ){

    return ResponseEntity.ok(authService.updateProfile(photo, removePhoto, name, email, password));
  }


  @PostMapping(value = "/profile/my", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateProfile(@Valid @RequestBody ProfileRequest request){

    return ResponseEntity.ok(authService.updateProfile(
        request.getRemovePhoto(), request.getName(), request.getEmail(), request.getPassword()));
  }

}
