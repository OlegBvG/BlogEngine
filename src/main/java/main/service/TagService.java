package main.service;

import java.util.ArrayList;
import java.util.List;
import main.api.response.Tag;
import main.api.response.TagResponse;
import org.springframework.stereotype.Service;

@Service
public class TagService {

  public TagResponse getTags(){
    TagResponse tagResponse = new TagResponse();
    List<Tag> tags = new ArrayList<>();

    Tag tag = new Tag();
    tag.setName("PHP");
    tag.setWeight(1);
    tags.add(tag);

    Tag tag2 = new Tag();
    tag2.setName("Python");
    tag2.setWeight(1);
    tags.add(tag2);

   tagResponse.setTags(tags);
    return tagResponse;
  }

}
