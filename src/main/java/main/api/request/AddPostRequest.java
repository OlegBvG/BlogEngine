package main.api.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPostRequest {
  private long timestamp;
  private int active;
  private String title;
  private List<String> tags;
  private String text;

  public long getTimestamp() {
    return timestamp;
  }

  public int getActive() {
    return active;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getTags() {
    return tags;
  }

  public String getText() {
    return text;
  }
}
