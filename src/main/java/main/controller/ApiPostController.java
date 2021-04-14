package main.controller;

import java.util.List;
import java.util.Map;
import main.api.request.AddCommentRequest;
import main.api.request.AddPostRequest;
import main.api.request.LikeRequest;
import main.api.request.ModerationRequest;
import main.api.response.PostResponse;
import main.api.response.RegistrationResponse;
import main.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ApiPostController {

  private PostService postService;

  public ApiPostController(PostService postService) {
    this.postService = postService;
  }


  @GetMapping("/post")
  public PostResponse post(@RequestParam Map<String, String> allParams) {

    return postService.getPartPosts(allParams);
  }

  @GetMapping("/post/search")
  public PostResponse postSearch(
      @RequestParam Map<String, String> allParams) {
    return postService.getSearchPosts(allParams);
  }

  @GetMapping("/post/byDate")
  public PostResponse postForDate(@RequestParam Map<String, String> allParams) {
    return postService.getSearchPostsByDate(allParams);
  }

  @GetMapping("/post/byTag")
  public PostResponse postByTag(
      @RequestParam Map<String, String> allParams) {
    return postService.getSearchPostsByTag(allParams);
  }

  @GetMapping("/post/{id}")
  public ResponseEntity<?> postById(@PathVariable Integer id) {

    return postService.getPostById(id);
  }

  @GetMapping("/post/my")
  public PostResponse postMy(
      @RequestParam(defaultValue = "0") int offset,
      @RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "") String status
  ) {

    return postService.getMyPosts(offset, limit, status);
  }

  @GetMapping("/post/moderation")
  public PostResponse postModeration(
      @RequestParam(defaultValue = "0") int offset,
      @RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "") String status   //inactive, pending, declined, published
  ) {

    return postService.getPostsToModeration(offset, limit, status);
  }

  @PostMapping("/post")
  public RegistrationResponse postAppend(@RequestBody AddPostRequest addPostRequest) {
    long timestamp = addPostRequest.getTimestamp();
    int active = addPostRequest.getActive();
    String title = addPostRequest.getTitle();
    List<String> tags = addPostRequest.getTags();
    String text = addPostRequest.getText();

    return postService.addPost(timestamp, active, title, tags, text);
  }

  @PutMapping("/post/{id}")
  public RegistrationResponse postById(@PathVariable Integer id,
      @RequestBody AddPostRequest addPostRequest) {

    long timestamp = addPostRequest.getTimestamp();
    int active = addPostRequest.getActive();
    String title = addPostRequest.getTitle();
    List<String> tags = addPostRequest.getTags();
    String text = addPostRequest.getText();

    return postService.editPost(id, timestamp, active, title, tags, text);
  }


  @PostMapping("/comment")
  public ResponseEntity<?> sendComment(@RequestBody AddCommentRequest addCommentRequest) {
    Integer parentId = addCommentRequest.getParentId();
    Integer postId = addCommentRequest.getPostId();
    String text = addCommentRequest.getText();

    return postService.sendComment(parentId, postId, text);
  }


  @PostMapping("/moderation")
  public ResponseEntity<?> postModeration(@RequestBody ModerationRequest moderationRequest) {
    Integer id = moderationRequest.getPost_id();
    String decision = moderationRequest.getDecision();

    return ResponseEntity.ok(postService.postModeration(id, decision));
  }

  @PostMapping("/post/like")
  public ResponseEntity<?> postLike(@RequestBody LikeRequest likeRequest) {
    int postId = likeRequest.getPostId();

    return ResponseEntity.ok(postService.postLike(postId));
  }


  @PostMapping("/post/dislike")
  public ResponseEntity<?> postDislike(@RequestBody LikeRequest likeRequest) {
    int postId = likeRequest.getPostId();

    return ResponseEntity.ok(postService.postDislike(postId));
  }

  @PostMapping(value = "/image"
      , consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> loadImage(
      @RequestParam("image") MultipartFile image
  ) {

    return postService.loadImage(image);
  }

}


