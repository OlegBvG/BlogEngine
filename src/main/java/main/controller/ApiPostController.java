package main.controller;

import java.util.Map;
import main.api.response.PostResponse;
import main.api.response.PostWatchResponse;
import main.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      @RequestParam(defaultValue = "https://localhost:8080/api/post/search?offset=0&limit=10&query=") Map<String, String> allParams) {
    return postService.getSearchPosts(allParams);
  }

  @GetMapping("/post/byDate")

  public PostResponse postForDate(@RequestParam Map<String, String> allParams) {
    return postService.getSearchPostsByDate(allParams);
  }

  @GetMapping("/post/byTag")

  public PostResponse postByTag(
      @RequestParam(defaultValue = "https://localhost:8080/api/post/search?offset=0&limit=10&tag=") Map<String, String> allParams) {
    return postService.getSearchPostsByTag(allParams);
  }

  @GetMapping("/post/{id}")

//  public PostWatchResponse postById(@PathVariable int id) {
  public PostWatchResponse postById(@PathVariable Integer id) {

    return postService.getPostById(id);
  }

//  @GetMapping("/post/moderation")
//
//  public PostResponse postAtModeration(@RequestParam Map<String,String> allParams){
//    allParams.entrySet();
//    return postService.getSearchPostsAtModeration(allParams);
//  }

}


