package main.service;

import java.util.ArrayList;
import main.api.response.PostResponse;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  public PostResponse getPartPosts() {
    PostResponse postResponse = new PostResponse();
    postResponse.setCount(390);
    postResponse.setPosts(new ArrayList<Integer>());
    return postResponse;
  }

}

/*ArrayList<Book> booksList = new ArrayList<Book>();
offset - сдвиг от 0 для постраничного вывода
limit - количество постов, которое надо вывести
mode - режим вывода (сортировка):
recent - сортировать по дате публикации, выводить сначала новые
popular - сортировать по убыванию количества комментариев
best - сортировать по убыванию количества лайков
early - сортировать по дате публикации, выводить сначала старые
 */