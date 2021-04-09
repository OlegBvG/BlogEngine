package main.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentRequest {

  int parent_id;
  int post_id;
  String text;

  public int getParent_id() {
    return parent_id;
  }

  public void setParent_id(int parrent_id) {
    this.parent_id = parrent_id;
  }

  public int getPost_id() {
    return post_id;
  }

  public void setPost_id(int post_id) {
    this.post_id = post_id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
