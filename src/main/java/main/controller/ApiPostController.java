package main.controller;

import java.util.Map;
import main.api.response.PostResponse;
import main.service.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiPostController {

  private PostService postService;

  public ApiPostController(PostService postService) {
    this.postService = postService;
  }


  @GetMapping("/post")

  public PostResponse post(@RequestParam Map<String,String> allParams){

    allParams.entrySet();
    return postService.getPartPosts(allParams);
  }

  @GetMapping("/post/search")

  public PostResponse postSearsh(@RequestParam Map<String,String> allParams){

    allParams.entrySet();
    return postService.getPartPosts(allParams);
  }

}


