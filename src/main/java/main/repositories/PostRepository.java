package main.repositories;

import java.util.Date;
import java.util.List;
import main.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
     {

  @Query(value =
      "SELECT *\n"
          + ", (SELECT users.name FROM blog.users users WHERE users.id=p.user_id) name\n"
          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
          + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
          + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
          + ", (SELECT COUNT(*) FROM blog.post_comments pc WHERE pc.post_id=p.id) commentCount\n"
          + "FROM blog.posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
          + "ORDER BY  p.time DESC",
      nativeQuery = true)

  List<Post> getPostsRecent(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, @Param("date") Date time, Pageable pageable);


       @Query(value =
           "SELECT *\n"
               + ", (SELECT users.name FROM blog.users users WHERE users.id=p.user_id) name\n"
               + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
               + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
               + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
               + ", (SELECT COUNT(*) FROM blog.post_comments pc WHERE pc.post_id=p.id) commentCount\n"
               + "FROM blog.posts p "
               + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
               + "ORDER BY  commentCount DESC",
           nativeQuery = true)
//          + "ORDER BY likeCount DESC, dislikeCount, p.time DESC",

       List<Post> getPostsPopular(@Param("isActive") int isActive,
           @Param("modStatus") String moderationStatus, @Param("date") Date time,  Pageable pageable);



       @Query(value =
           "SELECT *\n"
               + ", (SELECT users.name FROM blog.users users WHERE users.id=p.user_id) name\n"
               + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
               + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
               + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
               + ", (SELECT COUNT(*) FROM blog.post_comments pc WHERE pc.post_id=p.id) commentCount\n"
               + "FROM blog.posts p "
               + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
               + "ORDER BY  likeCount DESC",
           nativeQuery = true)

       List<Post> getPostsBest(@Param("isActive") int isActive,
           @Param("modStatus") String moderationStatus, @Param("date") Date time,  Pageable pageable);



       @Query(value =
           "SELECT *\n"
               + ", (SELECT users.name FROM blog.users users WHERE users.id=p.user_id) name\n"
               + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
               + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
               + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
               + ", (SELECT COUNT(*) FROM blog.post_comments pc WHERE pc.post_id=p.id) commentCount\n"
               + "FROM blog.posts p "
               + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
               + "ORDER BY  p.time",
           nativeQuery = true)

       List<Post> getPostsEarly(@Param("isActive") int isActive,
           @Param("modStatus") String moderationStatus, @Param("date") Date time,  Pageable pageable);



       @Query(value =
           "SELECT COUNT(*)\n"
               + "FROM blog.posts p "
               + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n",
           nativeQuery = true)

       int getPostsCount(@Param("isActive") int isActive,
           @Param("modStatus") String moderationStatus, @Param("date") Date time);


}
