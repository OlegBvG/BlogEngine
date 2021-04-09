package main.api.request;

import lombok.Data;

@Data
public class LikeRequest {
  private int post_id;

  public int getPostId() {
    return post_id;
  }

  public void setPostId(int post_id) {
    this.post_id = post_id;
  }

  public LikeRequest() {
  }
}
