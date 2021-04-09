package main.api.response;

import lombok.Data;

@Data
public class StatisticsResponse {
  private int postsCount;
  private int likesCount;
  private int dislikesCount;
  private int viewsCount;
  private long firstPublication;


  public StatisticsResponse() {

  }

  public void setPostsCount(int postsCount) {
    this.postsCount = postsCount;
  }

  public void setLikesCount(int likesCount) {
    this.likesCount = likesCount;
  }

  public void setDislikesCount(int dislikesCount) {
    this.dislikesCount = dislikesCount;
  }

  public void setViewsCount(int viewsCount) {
    this.viewsCount = viewsCount;
  }

  public void setFirstPublication(long firstPublication) {
    this.firstPublication = firstPublication;
  }
}
