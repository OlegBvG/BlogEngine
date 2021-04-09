package main.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import lombok.Data;

@Data
public class RegistrationResponse {

  private boolean result;

  @JsonInclude(Include.NON_NULL)
  Map<String, String> errors;


  public RegistrationResponse() {

  }


  public void setResult(boolean result) {
    this.result = result;
  }

  public void setErrors(Map<String, String> errors) {
    this.errors = errors;
  }


}
