package main.repositories;

import main.model.TagToPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TagToPostRepository extends JpaRepository<TagToPost, Long> {
  @Query(value =
      "SELECT count(*) "
          + "FROM tag2post "
          + "where post_id=2 and tag_id=10 ",
      nativeQuery = true)
  int countTagToPost(@Param("idPost") int idPost,
      @Param("idTag") int idTag);
}
/*
SELECT count(*) FROM blog.tag2post where post_id=2 and tag_id=10;
 int getPostsCount(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

public interface TagRepository  {



  Optional<Tags> findByName(String name);

  @Modifying
  @Query(value =
      "INSERT INTO tags "
          + "(name) "
          + "VALUES (:name)",
      nativeQuery = true)
  void addTag(@Param("name") String name);
 */