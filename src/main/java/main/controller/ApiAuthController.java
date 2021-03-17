package main.controller;

import java.security.Principal;
import main.api.request.LoginRequest;
import main.api.response.LoginResponse;
import main.api.response.UserLoginResponse;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;

  @Autowired
  public ApiAuthController(
      AuthenticationManager authenticationManager, UserRepository userRepository) {
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    Authentication auth = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(auth);
    User user = (User) auth.getPrincipal();
//-----------------------
//    main.model.User currentUser =
//        userRepository.findByEmail(user.getUsername())
//            .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));
//
//    UserLoginResponse userResponse = new UserLoginResponse();
//    userResponse.setEmail(currentUser.getEmail());
//    userResponse.setModeration(currentUser.getIs_moderator() == 1);
//    userResponse.setId(currentUser.getId());
//
//
//
//    LoginResponse loginResponse = new LoginResponse();
//    loginResponse.setResult(true);
//    loginResponse.setUserLoginResponse(userResponse);
//--------------------------

//    System.out.println(loginRequest.getEmail());
//    System.out.println(loginRequest.getPassword());
//    return ResponseEntity.ok(new LoginResponse());
    return ResponseEntity.ok(getloginResponse(user.getUsername()));

  }

  @GetMapping("/check")
  public ResponseEntity<LoginResponse> check(Principal principal){
    if (principal == null){
      return ResponseEntity.ok(new LoginResponse());
    }

    return ResponseEntity.ok(getloginResponse(principal.getName()));
  }

  private LoginResponse getloginResponse(String email){
    main.model.User currentUser =
        userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(email));

    UserLoginResponse userResponse = new UserLoginResponse();
    userResponse.setEmail(currentUser.getEmail());
    userResponse.setName(currentUser.getName());
    userResponse.setModeration(currentUser.getIs_moderator() == 1);
    userResponse.setId(currentUser.getId());



    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setResult(true);
    loginResponse.setUserLoginResponse(userResponse);

    return loginResponse;
  }

}
