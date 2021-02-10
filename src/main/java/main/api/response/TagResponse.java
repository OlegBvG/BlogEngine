package main.api.response;

import java.util.List;

public class TagResponse {
  private List<Tag> tags;

  public List getTags() {
    return tags;
  }

  public void setTags(List tags) {
    this.tags = tags;
  }
}
