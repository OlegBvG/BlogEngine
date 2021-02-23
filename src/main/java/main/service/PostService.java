package main.service;

import static java.lang.Integer.min;
import static org.thymeleaf.util.StringUtils.concat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import main.api.response.PostResponse;
import main.api.response.PostWatchResponse;
import main.model.Post;
import main.repositories.CommentsToWatch;
import main.repositories.PostRepository;
import main.repositories.PostToView;
import main.repositories.UserToView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

  @Autowired
  public PostRepository postRepository;

  @Transactional

  public PostResponse getPartPosts(Map<String, String> allParams) {

    int offset = Integer.parseInt(allParams.get("offset"));
    int limit = Integer.parseInt(allParams.get("limit"));
    String mode = allParams.get("mode");

    Pageable pageable = PageRequest.of(offset / limit, limit);
    List<Post> posts;
    switch (mode) {
      case "recent":
        posts = postRepository
            .getPostsRecent(1, "ACCEPTED", pageable);
        break;
      case "popular":
        posts = postRepository
            .getPostsPopular(1, "ACCEPTED", pageable);
        break;
      case "best":
        posts = postRepository
            .getPostsBest(1, "ACCEPTED", pageable);
        break;
      case "early":
        posts = postRepository
            .getPostsEarly(1, "ACCEPTED", pageable);
        break;
      default:
        posts = postRepository
            .getPostsRecent(1, "ACCEPTED", pageable);

    }

    List<PostToView> postToView;
    postToView = posts.stream().map(post ->
        new PostToView(post.getId(), post.getTime().getTime() / 1000,
            new UserToView(post.getUserId(), post.getUser().getName()),
            post.getTitle(),
            post.getText().substring(0, min(post.getText().length(), 150)).replaceAll("#", "")
                .concat("...")
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == 1)
            .count()
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == -1)
            .count()
            , post.getPostComments().size()
            , post.getViewCount()))
        .collect(
            Collectors.toList());


    PostResponse postResponse = new PostResponse();
    postResponse.setPosts(postToView);
    postResponse.setCount(postRepository.getPostsCount(1, "ACCEPTED"));

    return postResponse;
  }

  //-------------------

  public PostResponse getSearchPosts(Map<String, String> allParamsSearsh) {

    int offset = Integer.parseInt(allParamsSearsh.get("offset"));
    int limit = Integer.parseInt(allParamsSearsh.get("limit"));
    String query = allParamsSearsh.get("query").trim();


    Pageable pageable = PageRequest.of(offset / limit, limit);
    List<Post> posts;

    int countPosts = 0;
    if (query.length() == 0) {
      posts = postRepository
          .getPostsRecent(1, "ACCEPTED", pageable);
      countPosts = postRepository.getPostsCount(1, "ACCEPTED");
    } else {
      posts = postRepository
          .getPostsSearchQuery(query, 1, "ACCEPTED", pageable);
      countPosts = postRepository.getPostsSearchQueryCount(query, 1, "ACCEPTED");
    }

    List<PostToView> postToView;
    postToView = posts.stream().map(post ->
        new PostToView(post.getId(), post.getTime().getTime() / 1000,
            new UserToView(post.getUserId(), post.getUser().getName()),
            post.getTitle(),
            post.getText().substring(0, min(post.getText().length(), 150)).replaceAll("#", "")
                .concat("...")
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == 1)
            .count()
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == -1)
            .count()
            , post.getPostComments().size()
            , post.getViewCount()))
        .collect(
            Collectors.toList());


    PostResponse postResponse = new PostResponse();
    postResponse.setPosts(postToView);
    postResponse.setCount(countPosts);

    return postResponse;
  }

  public PostResponse getSearchPostsByDate(Map<String, String> allParams) {

    int offset = Integer.parseInt(allParams.get("offset"));
    int limit = Integer.parseInt(allParams.get("limit"));
    String date = allParams.get("date");

    Pageable pageable = PageRequest.of(offset / limit, limit);
    List<Post> posts;

    int countPosts = 0;
    posts = postRepository
        .getPostsSearchByDate(date, 1, "ACCEPTED", pageable);
    countPosts = postRepository.getPostsSearchByDateCount(date, 1, "ACCEPTED");

    List<PostToView> postToView;
    postToView = posts.stream().map(post ->
        new PostToView(post.getId(), post.getTime().getTime() / 1000,
            new UserToView(post.getUserId(), post.getUser().getName()),
            post.getTitle(),
            post.getText().substring(0, min(post.getText().length(), 150)).replaceAll("#", "")
                .concat("...")
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == 1)
            .count()
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == -1)
            .count()
            , post.getPostComments().size()
            , post.getViewCount()))
        .collect(
            Collectors.toList());

    PostResponse postResponse = new PostResponse();
    postResponse.setPosts(postToView);
    postResponse.setCount(countPosts);

    return postResponse;

  }

  public PostResponse getSearchPostsByTag(Map<String, String> allParams) {

    int offset = Integer.parseInt(allParams.get("offset"));
    int limit = Integer.parseInt(allParams.get("limit"));
    String tag = concat("#", allParams.get("tag"));

    Pageable pageable = PageRequest.of(offset / limit, limit);
    List<Post> posts;

    int countPosts = 0;
    posts = postRepository
        .getPostsSearchByTag(tag, 1, "ACCEPTED", pageable);
    countPosts = postRepository.getPostsSearchByTagCount(tag, 1, "ACCEPTED");

    List<PostToView> postToView;
    postToView = posts.stream().map(post ->
        new PostToView(post.getId(), post.getTime().getTime() / 1000,
            new UserToView(post.getUserId(), post.getUser().getName()),
            post.getTitle(),
            post.getText().substring(0, min(post.getText().length(), 150)).replaceAll("#", "")
                .concat("...")
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == 1)
            .count()
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == -1)
            .count()
            , post.getPostComments().size()
            , post.getViewCount()))
        .collect(
            Collectors.toList());

    PostResponse postResponse = new PostResponse();
    postResponse.setPosts(postToView);
    postResponse.setCount(countPosts);

    return postResponse;

  }

//  ------------Получение поста---------------

  public PostWatchResponse getPostById(int id) {
    PostWatchResponse postWatchResponse = new PostWatchResponse();
    Post post = postRepository.getPostById(id, 1, "ACCEPTED");

    postWatchResponse.setId(post.getId());
    postWatchResponse.setTimestamp(post.getTime().getTime() / 1000);
    postWatchResponse.setActive(post.getIsActive() == 1);
    postWatchResponse.setUser(new UserToView(post.getUserId(), post.getUser().getName()));
    postWatchResponse.setTitle(post.getTitle());
    postWatchResponse.setText(post.getText());
    postWatchResponse.setLikeCount(
        (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == 1).count());
    postWatchResponse.setDislikeCount(
        (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == -1).count());
    postWatchResponse.setViewCount(post.getViewCount());
    postWatchResponse.setComments(post.getPostComments().stream().map(c -> new CommentsToWatch(c)).collect(
        Collectors.toSet()));
    postWatchResponse
        .setTags(post.getPostTags().stream().map(t -> t.getName()).collect(Collectors.toList()));


    return postWatchResponse;
  }

//
//  public PostResponse getSearchPostsAtModeration(Map<String, String> allParams) {
//
//    int offset = Integer.parseInt(allParams.get("offset"));
//    int limit = Integer.parseInt(allParams.get("limit"));
//    String status = allParams.get("status");
//
//    Pageable pageable = PageRequest.of(offset / limit, limit);
//    List<Post> posts;
//
//    int countPosts = 0;
//    int moderatorId = 1;
//    posts = postRepository
//        .getPostsSearchAtModeration(status, moderatorId, 1, "ACCEPTED", new Date(), pageable);
//    countPosts = postRepository.getPostsSearchAtModerationCount(status, 1, "ACCEPTED", new Date());
//
//
//    List<PostToView> postToView;
//    postToView = posts.stream().map(post ->
//        new PostToView(post.getId(), post.getTime().getTime() / 1000,
//            new UserToView(post.getUser_id(), post.getUser().getName()),
//            post.getTitle(), post.getText().substring(0, min(post.getText().length(), 150)).replaceAll("#", "").concat("...")
//            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == 1)
//            .count()
//            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == -1)
//            .count()
//            ,  post.getPostComments().size()
//            , post.getView_count()))
//        .collect(
//            Collectors.toList());
//
//
//    PostResponse postResponse = new PostResponse();
//    postResponse.setPosts(postToView);
//    postResponse.setCount(countPosts);
//
//    return postResponse;
//
//  }


}


/*
offset - сдвиг от 0 для постраничного вывода
limit - количество постов, которое надо вывести
mode - режим вывода (сортировка):
recent - сортировать по дате публикации, выводить сначала новые
popular - сортировать по убыванию количества комментариев
best - сортировать по убыванию количества лайков
early - сортировать по дате публикации, выводить сначала старые

 */