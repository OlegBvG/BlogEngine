package main.controller;

import main.api.response.InitResponse;
import main.api.response.SettingsResponse;
import main.api.response.TagResponse;
import main.service.SettingsService;
import main.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

  private final SettingsService settingsService;
  private final InitResponse initResponse;
  private TagService tagService;

  public ApiGeneralController(SettingsService settingsService,
      InitResponse initResponse, TagService tagService) {
    this.settingsService = settingsService;
    this.initResponse = initResponse;
    this.tagService = tagService;
  }

  @GetMapping("/settings")
  private SettingsResponse settings() {
//    return new SettingsResponse();
    return settingsService.getGlobalSettings();
  }

  @GetMapping("/init")
  private InitResponse init() {
//  private InitResponse init(@RequestBody InitResponse initResponse){

    return initResponse;
  }

  @GetMapping("/tag")
  private TagResponse tagResponse(){
    return tagService.getTags();

  }

}
/*
@RestController
@RequestMapping("/api")
public class ApiPostController {

  private PostService postService;

  public ApiPostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/post")
  private PostResponse post(){

//    return new PostResponse();
    return postService.getPartPosts();
  }

  @GetMapping("/post")
  private PostResponse post(){

//    return new PostResponse();
    return postService.getPartPosts();
  }
 */