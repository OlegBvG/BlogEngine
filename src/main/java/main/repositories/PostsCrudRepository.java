package main.repositories;

import java.util.Date;
import java.util.List;
import main.model.ModerationStatus;
import main.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostsCrudRepository extends CrudRepository<Post, Long> {
//  List<Post> @Query(
//
//          "SELECT * FROM posts p WHERE is_active= :isActive AND moderation_status= :modStatus AND "
//              +
//              "time<= :date ORDER BY (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1)"
//              +
//              " DESC, (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1), p.time DESC"
//      nativeQuery = true);

  List<Post> findByIsActiveAndModerationStatusAndTimeBefore(
            int is_active, ModerationStatus moderation_status, Date time);
//  List<Posts> findByIsActiveAndModerationStatusAndTimeBefore(
//            int is_active, String moderation_status, Date time);
//      int isActive, String moderationStatus, Date time, Pageable pageable);
}
//  Optional<Posts> findByCode(String code);