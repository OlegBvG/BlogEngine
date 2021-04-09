package main.api.request;

public class ModerationRequest {
  private  int post_id;
  private String decision;

  public int getPost_id() {
    return post_id;
  }

  public void setPost_id(int post_id) {
    this.post_id = post_id;
  }

  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }

  public ModerationRequest() {
  }
}
