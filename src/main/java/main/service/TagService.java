package main.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import main.api.response.Tag;
import main.api.response.TagResponse;
import main.repositories.PostRepository;
import main.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagService {

  @Autowired
  public TagRepository tagRepository;
  @Autowired
  public PostRepository postRepository;

  @Transactional

  public TagResponse getTags() {

    double countPosts = postRepository.getPostsCount(1, "ACCEPTED");
    TagResponse tagResponse = new TagResponse();

    List<Tag> tags = tagRepository.getTags().stream()
        .map(t -> new Tag(t.getName(), t.getTagPosts().stream()
            .filter(tagPost -> tagPost.getModerationStatus().toString().equals("ACCEPTED"))
            .filter(tagPost -> !tagPost.getTime().after(new Date()))
            .count() / countPosts)).collect(
            Collectors.toList());

    tagResponse.setTags(tags);
    return tagResponse;
  }

}
