package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
  private boolean result;
  @JsonProperty("user")
  private UserLoginResponse userLoginResponse;

  public void setResult(boolean result) {
    this.result = result;
  }

  public void setUserLoginResponse(UserLoginResponse userLoginResponse) {
    this.userLoginResponse = userLoginResponse;
  }
}
