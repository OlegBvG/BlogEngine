package main.service;

import static java.lang.Integer.min;
import static main.model.ModerationStatus.ACCEPTED;
import static main.model.ModerationStatus.DECLINED;
import static main.model.ModerationStatus.NEW;
import static org.thymeleaf.util.StringUtils.concat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.api.response.PostResponse;
import main.api.response.PostWatchResponse;
import main.api.response.RegistrationResponse;
import main.api.response.SendCommentResponse;
import main.api.response.StatisticsResponse;
import main.model.ModerationStatus;
import main.model.Post;
import main.model.PostComments;
import main.model.PostVotes;
import main.model.TagToPost;
import main.repositories.CommentsToWatch;
import main.repositories.PostCommentsRepository;
import main.repositories.PostRepository;
import main.repositories.PostToView;
import main.repositories.PostVotesRepository;
import main.repositories.TagRepository;
import main.repositories.TagToPostRepository;
import main.repositories.UserToView;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PostService {

  @Autowired
  public AuthService authService;

  @Autowired
  public TagRepository tagRepository;

  @Autowired
  public PostRepository postRepository;

  @Autowired
  public PostCommentsRepository postCommentsRepository;

  @Autowired
  public PostVotesRepository postVotesRepository;

  @Autowired
  public SettingsService settingsService;

  @Autowired
  public TagToPostRepository tagToPostRepository;

  @Transactional

  public PostResponse getPartPosts(Map<String, String> allParams) {

    Integer offset = Integer.valueOf((allParams.get("offset")));
    Integer limit = Integer.valueOf((allParams.get("limit")));
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
            html2text(post.getText().replaceAll("#.+", ""))
                .substring(0, min(html2text(post.getText().replaceAll("#.+", "")).length(), 150))
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
            html2text(post.getText().replaceAll("#.+", ""))
                .substring(0, min(html2text(post.getText().replaceAll("#.+", "")).length(), 150))
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


  public static String html2text(String html) {
    return Jsoup.parse(html).text();
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
            html2text(post.getText().replaceAll("#.+", ""))
                .substring(0, min(html2text(post.getText().replaceAll("#.+", "")).length(), 150))
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
            html2text(post.getText().replaceAll("#.+", ""))
                .substring(0, min(html2text(post.getText().replaceAll("#.+", "")).length(), 150))
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

  public ResponseEntity<?> getPostById(int id) {
    PostWatchResponse postWatchResponse = new PostWatchResponse();
    Post post = postRepository.getPostById(id);

    if (post.equals(null)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

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
    postWatchResponse
        .setComments(post.getPostComments().stream().map(c -> new CommentsToWatch(c)).collect(
            Collectors.toSet()));
    postWatchResponse
        .setTags(post.getPostTags().stream().map(t -> t.getName()).collect(Collectors.toList()));

    if (!authService.isCurrentUserAuthenticated()) {
      post.setViewCount(post.getViewCount() + 1);
      postRepository.save(post);
    } else if (!authService.isCurrentUserModerator() && authService.getCurrentUserId() != post
        .getUserId()) {
      post.setViewCount(post.getViewCount() + 1);
      postRepository.save(post);
    }

    return ResponseEntity.ok(postWatchResponse);
  }

  public ResponseEntity<?> getStatistics() {

    if (!authService.isCurrentUserModerator() && !settingsService.getGlobalSettings()
        .isStatisticsIsPublic()) {
      return new ResponseEntity<>(HttpStatus.valueOf(401));
    }

    StatisticsResponse statisticsResponse = new StatisticsResponse();

    statisticsResponse.setPostsCount(postRepository.getStatisticsCount());
    statisticsResponse.setViewsCount(postRepository.getStatisticsView());
    statisticsResponse.setFirstPublication(postRepository.getStatisticsTime());
    statisticsResponse.setLikesCount(postRepository.getStatisticsLikes());
    statisticsResponse.setDislikesCount(postRepository.getStatisticsDislikes());

    return ResponseEntity.ok(statisticsResponse);
  }

  public StatisticsResponse getMyStatistics() {

    StatisticsResponse statisticsResponse = new StatisticsResponse();
    int myId = authService.getCurrentUserId();

    statisticsResponse.setPostsCount(postRepository.getMyStatisticsCount(myId));
    statisticsResponse.setViewsCount(postRepository.getMyStatisticsView(myId));
    statisticsResponse.setFirstPublication(postRepository.getMyStatisticsTime(myId));
    statisticsResponse.setLikesCount(postRepository.getMyStatisticsLikes(myId));
    statisticsResponse.setDislikesCount(postRepository.getMyStatisticsDislikes(myId));

    return statisticsResponse;
  }

  public PostResponse getMyPosts(Integer offset, Integer limit, String status) {

    Pageable pageable = PageRequest.of(offset / limit, limit);
    List<Post> posts = null;
    HashMap<String, String> moderationStatus = new HashMap<>();
    moderationStatus.put("pending", "NEW");
    moderationStatus.put("declined", "DECLINED");
    moderationStatus.put("published", "ACCEPTED");

    int countPosts = 0;
    int currentUserId = authService.getCurrentUserId();

    if (status.equals("inactive")) {
      posts = postRepository
          .getMyPostsInactive(currentUserId, 0, pageable);
      countPosts = postRepository
          .getMyPostsInactive(currentUserId, 0);
    } else {
      posts = postRepository
          .getMyPostsActive(currentUserId, 1, moderationStatus.get(status), pageable);
      countPosts = postRepository
          .getMyPostsActive(currentUserId, 1, moderationStatus.get(status));
    }

    List<PostToView> postToView;
    assert posts != null;
    postToView = posts.stream().map(post ->
        new PostToView(post.getId(), post.getTime().getTime() / 1000,
            new UserToView(post.getUserId(), post.getUser().getName()),
            post.getTitle(),
            html2text(post.getText().replaceAll("#.+", ""))
                .substring(0, min(html2text(post.getText().replaceAll("#.+", "")).length(), 150))

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

  public PostResponse getPostsToModeration(Integer offset, Integer limit, String status) {

    Pageable pageable = PageRequest.of(offset / limit, limit);
    List<Post> posts = null;
    HashMap<String, String> moderationStatus = new HashMap<>();
    moderationStatus.put("new", "NEW");
    moderationStatus.put("declined", "DECLINED");
    moderationStatus.put("accepted", "ACCEPTED");

    int countPosts = 0;
    int currentUserId = authService.getCurrentUserId();

    if (status.equals("new")) {
      posts = postRepository
          .getPostsNewToModeration(pageable);
      countPosts = postRepository
          .getPostsNewToModerationCount();
    } else {
      posts = postRepository
          .getPostsToModeration(currentUserId, moderationStatus.get(status), pageable);
      countPosts = postRepository
          .getPostsToModerationCount(currentUserId, moderationStatus.get(status));
    }

    List<PostToView> postToView;
    assert posts != null;
    postToView = posts.stream().map(post ->
        new PostToView(post.getId(), post.getTime().getTime() / 1000,
            new UserToView(post.getUserId(), post.getUser().getName()),
            post.getTitle(),
            html2text(post.getText().replaceAll("#.+", ""))
                .substring(0, min(html2text(post.getText().replaceAll("#.+", "")).length(), 150))

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


  public RegistrationResponse addPost(long timestamp, int active, String title, List<String> tags,
      String text) {

    Map<String, String> errors = new HashMap<String, String>();
    RegistrationResponse registrationResponse = new RegistrationResponse();

    ModerationStatus modStatus = NEW;

    if (settingsService.getGlobalSettings().isPostPremoderation()) {
      modStatus = ACCEPTED;
    }

    if (title.trim().length() < 3) {
      errors.put("title", "Заголовок не установлен");
    }
    if (text.trim().length() < 50) {
      errors.put("text", "Текст публикации слишком короткий");
    }

    if (errors.isEmpty()) {
      timestamp = Math.max(timestamp * 1000, new Date().getTime());


      int idNewPost =
          postRepository
          .saveAndFlush(new Post(active, modStatus, authService.getCurrentUserId()
              , new Timestamp(timestamp), title, text, 0))
              .getId();

      if (idNewPost > 0) {
        registrationResponse.setResult(true);
        if (tags.size() > 0) {
          Stream<String> streamTags = tags.stream();
          streamTags.forEach((tag) -> checkTagBeforeAdd(tag, idNewPost));
        }
      }


    } else {
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);
    }

    return registrationResponse;
  }

  public RegistrationResponse editPost(Integer id, long timestamp, int active, String title,
      List<String> tags, String text) {

    Map<String, String> errors = new HashMap<String, String>();
    RegistrationResponse registrationResponse = new RegistrationResponse();

    if (title.trim().length() < 3) {
      errors.put("title", "Заголовок не установлен");
    }
    if (text.trim().length() < 50) {
      errors.put("text", "Текст публикации слишком короткий");
    }

    if (errors.isEmpty()) {
      timestamp = Math.max(timestamp * 1000, new Date().getTime());

      if (tags.size() > 0) {
        Stream<String> streamTags = tags.stream();
        streamTags.forEach((tag) -> checkTagBeforeAdd(tag, id));
      }

      Post post = postRepository.getPostById(id);
      post.setIsActive(active);
      post.setText(text);
      post.setTime(new Timestamp(timestamp));
      post.setTitle(title);

      if (!authService.isCurrentUserModerator()) {
        post.setModerationStatus(ModerationStatus.valueOf("NEW"));
      }
      postRepository.saveAndFlush(post);
      registrationResponse.setResult(true);

    } else {
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);
    }

    return registrationResponse;
  }


  public ResponseEntity<?> sendComment(Integer parent_id, Integer post_id, String text) {

    Map<String, String> errors = new HashMap<String, String>();
    SendCommentResponse sendCommentResponse = new SendCommentResponse();

    if (text.trim().length() < 30) {
      errors.put("text", "Текст комментария не задан или слишком короткий");
    }

    if (post_id != null && !postRepository.findById(post_id).isPresent()) {
      return new ResponseEntity<>(HttpStatus.valueOf(404));
    }

    if (parent_id != null && postCommentsRepository.countParentId(parent_id) == 0) {
      return new ResponseEntity<>(HttpStatus.valueOf(404));
    }

    if (errors.isEmpty()) {

      int newPostCommentsId = postCommentsRepository
          .saveAndFlush(new PostComments(parent_id
              , post_id, authService.getCurrentUserId(), new Timestamp(new Date().getTime()), text))
          .getId();

      sendCommentResponse.setId(newPostCommentsId);
      sendCommentResponse.setResult(true);

    } else {
      sendCommentResponse.setResult(false);
      sendCommentResponse.setErrors(errors);
    }

    return ResponseEntity.ok(sendCommentResponse);

  }

  public RegistrationResponse postModeration(Integer id, String decision) {

    RegistrationResponse registrationResponse = new RegistrationResponse();
    Post post = postRepository.getPostById(id);

    Map<String, ModerationStatus> moderationStatus = new HashMap<String, ModerationStatus>();
    moderationStatus.put("accept", ACCEPTED);
    moderationStatus.put("decline", DECLINED);

    if (authService.isCurrentUserModerator()) {
      post.setModerationStatus(moderationStatus.get(decision));
      post.setModeratorId(authService.getCurrentUserId());
      Post postModerated = postRepository.saveAndFlush(post);
      registrationResponse.setResult(!postModerated.equals(null));

    }

    return registrationResponse;
  }


  public RegistrationResponse postLike(int postId) {

    RegistrationResponse registrationResponse = new RegistrationResponse();
    int userId = authService.getCurrentUserId();

    if (userId == 0) {
      return registrationResponse;
    }

    Optional<PostVotes> postVotesOptional = postVotesRepository
        .findByPostIdAndUserId(postId, userId);

    if (postVotesOptional.isPresent()) {

      if (postVotesOptional.get().getValue() == -1) {
        postVotesOptional.get().setValue(1);
        postVotesRepository.saveAndFlush(postVotesOptional.get());
        registrationResponse.setResult(true);
      }

    } else {

      postVotesRepository.saveAndFlush(
          new PostVotes(userId, postId, new Timestamp(new Date().getTime()), 1));
      registrationResponse.setResult(true);
    }

    return registrationResponse;
  }

  public RegistrationResponse postDislike(int postId) {

    RegistrationResponse registrationResponse = new RegistrationResponse();
    int userId = authService.getCurrentUserId();

    if (userId == 0) {
      return registrationResponse;
    }

    Optional<PostVotes> postVotesOptional = postVotesRepository
        .findByPostIdAndUserId(postId, userId);

    if (postVotesOptional.isPresent()) {

      if (postVotesOptional.get().getValue() == 1) {
        postVotesOptional.get().setValue(-1);
        postVotesRepository.saveAndFlush(postVotesOptional.get());
        registrationResponse.setResult(true);
      }

    } else {

      postVotesRepository.saveAndFlush(
          new PostVotes(userId, postId, new Timestamp(new Date().getTime()), -1));
      registrationResponse.setResult(true);
    }

    return registrationResponse;
  }

  public void checkTagBeforeAdd(String name, int idPost) {
    if (!tagRepository.findByName(name).isPresent()) {
      tagRepository.addTag(name);
    }

    int idTag = tagRepository.findByName(name).get().getId();

    if (tagToPostRepository.countTagToPost(idPost, idTag) == 0){
      tagToPostRepository.saveAndFlush(new TagToPost(idPost, idTag));
    }

  }


  public ResponseEntity<?> loadImage(
      MultipartFile image) {

    Map<String, String> errors = new HashMap<String, String>();
    RegistrationResponse registrationResponse = new RegistrationResponse();

    String extension = FilenameUtils.getExtension(image.getOriginalFilename());
    if (!(extension
        .equalsIgnoreCase("JPG") || extension.equalsIgnoreCase("PNG"))) {

      errors.put("image", "Недопустимый формат файла");
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);

      return new ResponseEntity<>(registrationResponse, HttpStatus.BAD_REQUEST);
    }

    if (image.getSize() > 700000) {

      errors.put("image", "Размер файла превышаетдопустимый размер");
      registrationResponse.setResult(false);
      registrationResponse.setErrors(errors);

      return new ResponseEntity<>(registrationResponse, HttpStatus.BAD_REQUEST);
    }

    String pathRandom = authService.randomLine(12);
    StringBuffer sb = new StringBuffer(pathRandom);

    for (int i = 6; i > 0; i = i - 2) {
      sb.insert(i, "/");
    }
    sb.append(".jpg");
    sb.insert(0, "upload/");
    pathRandom = sb.toString();
    String dstFolder = sb.substring(0, 15);
    String fileName = sb.substring(16);
    String newFile = ImageService.imageLoad(image, dstFolder, fileName);

    return newFile.length() > 1
        ? ResponseEntity.ok(newFile) : new ResponseEntity<>(newFile, HttpStatus.BAD_REQUEST);
  }

}
