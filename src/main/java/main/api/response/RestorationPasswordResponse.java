package main.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestorationPasswordResponse {
  private boolean result;

  public void setResult(boolean result) {
    this.result = result;
  }
}
