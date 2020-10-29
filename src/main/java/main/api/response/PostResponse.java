package main.api.response;

import java.util.ArrayList;

public class PostResponse {
  private int count;
  private ArrayList posts;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public ArrayList getPosts() {
    return posts;
  }

  public void setPosts(ArrayList posts) {
    this.posts = posts;
  }
}

