package main.api.response;

import java.util.List;
import main.repositories.PostToView;

public class PostResponse {

  private Integer count;
  private List<PostToView> posts;

  public int getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public List<PostToView> getPosts() {
    return posts;
  }

  public void setPosts(List<PostToView> posts) {
    this.posts = posts;
  }

}
