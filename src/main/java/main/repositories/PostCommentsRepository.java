package main.repositories;

import java.util.Optional;
import main.model.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostCommentsRepository extends JpaRepository<PostComments, Long>{

  Optional<PostComments> findOneByParentId(Integer parentId);

  Optional<PostComments> findByPostId(Integer postId);

  @Query(value =
      "SELECT count(*) FROM post_comments where parent_id = :parentId",
      nativeQuery = true)
  int countParentId(@Param("parentId") int parentId);
}

