package main.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;

@Data
public class SendCommentResponse {

  @JsonProperty(defaultValue = "true")
  @JsonInclude(Include.NON_DEFAULT)

  private boolean result;

  @JsonInclude(Include.NON_NULL)
  Map<String, String> errors;

  @JsonInclude(Include.NON_DEFAULT)
  int id;

  public void setResult(boolean result) {
    this.result = result;
  }

  public void setErrors(Map<String, String> errors) {
    this.errors = errors;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SendCommentResponse() {
  }
}


