package main.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import main.api.response.PostResponse;
//import main.repositories.PostQueryRepository;
import main.model.Post;
import main.repositories.PostRepository;
import main.repositories.PostToView;
import main.repositories.UserToView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;
//  private PostQueryRepository postRepository;
  @Transactional

  public PostResponse getPartPosts() {
    Date date = new Date();

    PostResponse postResponse = new PostResponse();

    postRepository.getAllPosts(1, "ACCEPTED", date).stream()
        .forEach(p -> System.out.println(p.getUser().getName()));
    postRepository.getAllPosts(1, "ACCEPTED", date).stream()
        .forEach(p -> System.out.println(p.getPostVotes().stream().filter(postVotes -> postVotes.getValue()==1).count()));

    List<Post> posts = postRepository.getAllPosts(1, "ACCEPTED", date);



    List<PostToView> postToView;
    postToView = posts.stream().map(post ->
        new PostToView(1, 123,
            new UserToView(1, "пользователь"),
//              new User(post.getUser_id(), post.getUser().getName()),
//              post.getUser(),
            "Title", "getAnnounce()"
            , 1
            , 2
            , 3
//,5
            , 4
        ))
        .collect(
            Collectors.toList());
    postToView.stream().forEach(p -> System.out.println("ID - " + p.getId()));


/*
    List<PostToView> postToView;
      postToView = posts.stream().map(post ->
          new PostToView(post.getId(), post.getTime(),
              new UserToView(1, "post.getUser().getName()"),
//              new User(post.getUser_id(), post.getUser().getName()),
//              post.getUser(),
              post.getTitle(), "post.getAnnounce()"
              , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue()==1).count()
              , (int) post.getPostVotes().stream().filter(postVotes -> postVotes.getValue()==-1).count()
            , (int) post.getPostComments().stream().filter(postComments -> postComments.getId() > 0).count()
//,5
              , post.getView_count()
          ))
          .collect(
              Collectors.toList());
postToView.stream().forEach(p -> System.out.println("ID - " + p.getId()));

*/
//      postResponse.setPosts(postRepository.getAllPosts(1, "ACCEPTED", date));
      postResponse.setPosts(postToView);
      postResponse.setCount(postRepository.getAllPosts(1, "ACCEPTED", date).size());

      return postResponse;
  }

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