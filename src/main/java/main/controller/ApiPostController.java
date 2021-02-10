package main.controller;

import main.api.response.PostResponse;
import main.service.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiPostController {

  private PostService postService;

  public ApiPostController(PostService postService) {
    this.postService = postService;
  }


  @GetMapping("/post")

  private PostResponse post(){

    return postService.getPartPosts();
  }

}



//  public ApiPostController(PostServiceImpl postServiceImpl) {
//    this.postServiceImpl = postServiceImpl;
//  }

//  private PostsList postsList;
//  public ApiPostController(PostsList postsList){
//    this.postsList = postsList;
//  }
//  private List<Post> post(){

//  private PostService post(){

//    return new PostResponse();
//    return postService.getPartPosts();
//----------------    return postServiceImpl.getPostsAccepted();
//    List<Post> posts = CustomizedPostCrudRepository.findPosts();
//    List<Post> posts = CustomizedPostsCrudRepository.getBestPosts();
//    return CustomizedPostCrudRepository.
//    return posts;
//    List<Post> posts = CustomizedPostsCrudRepository.;
//    List<Post> posts = PostsList.getBestPosts;
//    return posts;
//  return postServiceImpl;

//List<Employees> employees = employeesCrudRepository.findEmployeesWithMoreThanSalary(10000L, Sort.by("lastName"));