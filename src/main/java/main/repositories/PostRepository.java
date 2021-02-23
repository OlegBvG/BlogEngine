package main.repositories;

import java.util.List;
import main.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  @Query(value =
      "SELECT *\n"
          + ", (SELECT users.name FROM users users WHERE users.id=p.user_id) name\n"
          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
          + ", (SELECT COUNT(*) FROM post_comments pc WHERE pc.post_id=p.id) commentCount\n"
          + "FROM blog.posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  p.time DESC",
      nativeQuery = true)
  List<Post> getPostsRecent(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);


  @Query(value =
      "SELECT *\n"
          + ", (SELECT users.name FROM blog.users users WHERE users.id=p.user_id) name\n"
          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
          + ", (SELECT COUNT(*) FROM post_comments pc WHERE pc.post_id=p.id) commentCount\n"
          + "FROM blog.posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  commentCount DESC",
      nativeQuery = true)

  List<Post> getPostsPopular(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);


  @Query(value =
      "SELECT *\n"
          + ", (SELECT users.name FROM users users WHERE users.id=p.user_id) name\n"
          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
          + ", (SELECT COUNT(*) FROM post_comments pc WHERE pc.post_id=p.id) commentCount\n"
          + "FROM blog.posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  likeCount DESC",
      nativeQuery = true)
  List<Post> getPostsBest(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);


  @Query(value =
      "SELECT *\n"
          + ", (SELECT users.name FROM users users WHERE users.id=p.user_id) name\n"
          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
          + ", (SELECT COUNT(*) FROM post_comments pc WHERE pc.post_id=p.id) commentCount\n"
          + "FROM blog.posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)
  List<Post> getPostsEarly(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus,  Pageable pageable);


  @Query(value =
      "SELECT COUNT(*)\n"
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n",
      nativeQuery = true)
  int getPostsCount(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);


  @Query(value =
      "SELECT  *\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:query% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)
  List<Post> getPostsSearchQuery(@Param("query") String query, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus,  Pageable pageable);


  @Query(value =
      "SELECT  COUNT(*)\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:query% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n",
      nativeQuery = true)
  int getPostsSearchQueryCount(@Param("query") String query, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

  //------------------ Список постов за указанную дату-------

  @Query(value =
      "SELECT  *\n"
          + "FROM posts p "
          + "WHERE date(p.time)= STR_TO_DATE(:dateQuery,GET_FORMAT(DATE,'ISO'))  AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  p.id",
      nativeQuery = true)
  List<Post> getPostsSearchByDate(@Param("dateQuery") String date, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);

  @Query(value =
      "SELECT  COUNT(*)\n"
          + "FROM posts p "
          + "WHERE date(p.time)= STR_TO_DATE(:dateQuery,GET_FORMAT(DATE,'ISO'))  AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n",
      nativeQuery = true)
  int getPostsSearchByDateCount(@Param("dateQuery") String date, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

  //-----------

  @Query(value =
      "SELECT  *\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:tag% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)
  List<Post> getPostsSearchByTag(@Param("tag") String tag, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);


  @Query(value =
      "SELECT  COUNT(*)\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:tag% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n",
      nativeQuery = true)
  int getPostsSearchByTagCount(@Param("tag") String tag, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

//------------------ Calendar-------

  @Query(value =
      "SELECT DISTINCT\n"
          + "year(time) year\n"
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY year",
      nativeQuery = true)
  List<Integer> getPostsYears(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

  @Query(value =
      "SELECT *\n"
          + "FROM posts p "
          + "WHERE year(p.time)= :yearPost AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)

  List<Post> getPostsForYear(@Param("yearPost") int yearPost, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

  //-----------Получение поста----------------


  @Query(value =
      "SELECT *\n"
          + "FROM posts p "
          + "WHERE id = :id AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_date() \n",
      nativeQuery = true)
  Post getPostById(@Param("id") int id, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);












//       @Query(value =
//           "SELECT  *\n"
//               + "FROM blog.posts p "
//               + "WHERE p.text LIKE %:tag% AND is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
//               + "ORDER BY  p.time",
//           nativeQuery = true)
//
//       List<Post> getPostsSearchAtModeration(@Param("status") String status, @Param("moderatorId") int moderatorId,
//           @Param("isActive") int isActive,
//           @Param("modStatus") String moderationStatus, @Param("date") Date time,  Pageable pageable);
//
//
//
//       @Query(value =
//           "SELECT  COUNT(*)\n"
//               + "FROM blog.posts p "
//               + "WHERE p.text LIKE %:tag% AND is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n",
//           nativeQuery = true)
//
//       int getPostsSearchAtModerationCount(@Param("tag") String tag, @Param("isActive") int isActive,
//           @Param("modStatus") String moderationStatus, @Param("date") Date time);

}
