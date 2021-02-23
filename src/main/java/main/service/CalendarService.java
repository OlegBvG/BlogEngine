package main.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import main.api.response.CalendarResponse;
import main.model.Post;
import main.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalendarService {

  @Autowired
  public PostRepository postRepository;
  @Transactional

  public CalendarResponse getCalendar(int yearParameter){

    List<Integer> years = postRepository.getPostsYears(1, "ACCEPTED");

    Map<String, Long> posts = postRepository.getPostsForYear(yearParameter, 1, "ACCEPTED")
        .stream()
        .collect(Collectors.groupingBy((Post::getTimeYMD), Collectors.counting()));

    CalendarResponse calendarResponse = new CalendarResponse(years, posts);
    return calendarResponse;
  }

}







