package main.api.response;

import java.util.List;
import main.repositories.PostToView;

public class PostResponse {
  private int count;
  private List<PostToView> posts;
//  private List<Post> posts;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public List getPosts() {
    return posts;
  }

  public void setPosts(List<PostToView> posts) {
    this.posts = posts;
  }

  //  public void setPosts(List posts) {
//    this.posts = posts;
//  }
//  public List<PostToView> setPosts(List<Post> posts) {
////    this.posts = posts;
//    List<PostToView> postToView;
////    List<Post> postTo;
//    postToView = posts.stream().map(post ->
//        new PostToView(post.getId(), post.getTime(),
//            new User(post.getUser_id(), post.getUser().getName()),
//            post.getTitle(), "post.getAnnounce()"
//            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue()==1).count()
//            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue()==-1).count()
////            , post.getPostComments().size()
//            , 5
//            , post.getView_count()
//        ))
//        .collect(
//            Collectors.toList());

//    postToView = postsQuery.stream().map(pQ ->
//        new PostToView(pQ.getPost().getId(), pQ.getPost().getTime(),
//            new User(pQ.getPost().getUser_id(), pQ.getName()),
//            pQ.getPost().getTitle(), pQ.getAnnounce(), pQ.getLikeCount(),
//            pQ.getDislikeCount(), pQ.getCommentCount(), pQ.getPost().getView_count()))
//        .collect(
//        Collectors.toList());

//  return postToView;
//  }

}

/*
 private int id;
  private Timestamp timestamp;
  private User user;
  private String title;
  private String announce;
  private int likeCount;
  private int dislikeCount;
  private int commentCount;
  private int viewCount;

List<String> collected = Stream.of("a", "b", "hello")
.map(string -> string.toUpperCase())
.collect(toList());
 */