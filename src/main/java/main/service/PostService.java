package main.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import main.api.response.PostResponse;
import main.model.Post;
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

//    this.allParams = allParams;

//    sortPosts.put("recent", "");
//    sortPosts.put("recent", "time");
//    sortPosts.put("popular", "commentCount DESC");
//    sortPosts.put("best", "likeCount DESC");
//    sortPosts.put("early", "time DESC");


//System.out.println(updateFoos());
//    Sort allNamesSort = new Sort(new Sort.Order(Sort.Direction.Desc, "firstName"), new Sort.Order(Sort.Direction.Asc, "lastName"))
//    Pageable pageable =  PageRequest.of(0, 10, Direction.DESC, "viewCount");
//    Pageable page = new PageRequest(0, 10, SortDirection.Asc, "firstName")
//repository.findByFirstName("Test", page)
//    Pageable pageable =  new PageRequest(0, 10, Direction.DESC, "viewCount");, Direction.DESC, "viewCount"
//    Pageable pageable =  PageRequest.of(0, 10);
//    Date date = new Date();

//    PostResponse postResponse = new PostResponse();

//    System.out.println(" postResponse.getOffset() - " + postResponse.Offset);

//    postRepository.getAllPosts(1, "ACCEPTED", date).stream()
//        .forEach(p -> System.out.println(p.getUser().getName()));
//    postRepository.getAllPosts(1, "ACCEPTED", date).stream()
//        .forEach(p -> System.out.println(p.getPostVotes().stream().filter(postVotes -> postVotes.getValue()==1).count()));

//    Page<Post> posts = (Page<Post>) postRepository.getAllPosts(1, "ACCEPTED", date, pageable);
//    pageable.

//    System.out.println("параметры " + allParams.get("offset"));
    int offset = Integer.parseInt(allParams.get("offset"));
    int limit = Integer.parseInt(allParams.get("limit"));
    String mode = allParams.get("mode");

//    Pageable pageable = PageRequest.of(offset/limit, limit, Sort.by("pv.likeCount"));
    Pageable pageable = PageRequest.of(offset / limit, limit);
    List<Post> posts;
    switch (mode){
      case "recent":
        posts = postRepository
            .getPostsRecent(1, "ACCEPTED", new Date(), pageable);
        break;
      case "popular":
         posts = postRepository
            .getPostsPopular(1, "ACCEPTED", new Date(), pageable);
         break;
      case "best":
        posts = postRepository
            .getPostsBest(1, "ACCEPTED", new Date(), pageable);
        break;
      case "early":
        posts = postRepository
            .getPostsEarly(1, "ACCEPTED", new Date(), pageable);
        break;
      default:
        posts = postRepository
            .getPostsRecent(1, "ACCEPTED", new Date(), pageable);

    }

    List<PostToView> postToView;
    postToView = posts.stream().map(post ->
        new PostToView(post.getId(), post.getTime().getTime() / 1000,
            new UserToView(post.getUser_id(), post.getUser().getName()),
            post.getTitle(), "post.getAnnounce()"
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == 1)
            .count()
            , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue() == -1)
            .count()
            ,  post.getPostComments().size()
            , post.getView_count()))
        .collect(
            Collectors.toList());


//    posts.stream().forEach(p -> System.out.println("ID - " + p.getId()));
//    System.out.println("---------------");
//    postToView.stream().forEach(p -> System.out.println("ID - " + p.getId()));



    PostResponse postResponse = new PostResponse();
    postResponse.setPosts(postToView);
    postResponse.setCount(postRepository.getPostsCount(1, "ACCEPTED", new Date()));

    return postResponse;
  }

//  public Map<String, String> getSortPosts() {
//    return sortPosts;
//  }

}

//    postResponse.setPosts(postRepository.getAllPostsQuery(1, "ACCEPTED", date));
//    postResponse.setCount(postRepository.getAllPostsQuery(1, "ACCEPTED", date).size());

//    public List<PostToView> setPosts(List< Post > posts) {
//    this.posts = posts;

//              , 5
//    postResponse.setCount(390);
//    postResponse.setPosts(new ArrayList<Integer>());
//    postResponse.setPosts(customizedPostsCrudRepository.getAllPosts(1, ACCEPTED, date));
//    postResponse.setCount(customizedPostsCrudRepository.getAllPosts(1, ACCEPTED, date).size());
//    postResponse.setPosts(customizedPostsCrudRepository.getAllPosts(1, "ACCEPTED", date, pageable));
//    postResponse.setCount(customizedPostsCrudRepository.getAllPosts(1, "ACCEPTED", date, pageable).size());

//    postResponse.setPosts(postRepository.getAllPostsQuery(1, "ACCEPTED", date));
//    postResponse.setCount(postRepository.getAllPostsQuery(1, "ACCEPTED", date).size());
//    postResponse.setPosts(customizedPostsCrudRepository.findByIsActive(1, ACCEPTED,
//        date));
//    postResponse.setCount(customizedPostsCrudRepository.findByIsActive(1, ACCEPTED,
//        date).size());
//    postResponse.setPosts(postsCrudRepository.findByIsActiveAndModerationStatusAndTimeBefore(1, ACCEPTED,
//        date));
//    postResponse.setCount(postsCrudRepository.findByIsActiveAndModerationStatusAndTimeBefore(1, ACCEPTED,
//        date).size());
/*
offset - сдвиг от 0 для постраничного вывода
limit - количество постов, которое надо вывести
mode - режим вывода (сортировка):
recent - сортировать по дате публикации, выводить сначала новые
popular - сортировать по убыванию количества комментариев
best - сортировать по убыванию количества лайков
early - сортировать по дате публикации, выводить сначала старые


@Service
public class PostService {
  @Autowired
  private PostsCrudRepository postsCrudRepository;
  @Transactional

  public PostResponse getPartPosts() {
    Date date = new Date();
    PostResponse postResponse = new PostResponse();
    postResponse.setCount(390);
//    postResponse.setPosts(new ArrayList<Integer>());
    postResponse.setPosts(postsCrudRepository.findByIsActiveAndModerationStatusAndTimeBefore(1, ACCEPTED,
        date));
    postResponse.setCount(postsCrudRepository.findByIsActiveAndModerationStatusAndTimeBefore(1, ACCEPTED,
        date).size());

    return postResponse;
  }

}

 */