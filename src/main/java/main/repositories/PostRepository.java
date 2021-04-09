package main.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import main.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {

  @Query(value =
      "SELECT *\n"
          + ", (SELECT users.name FROM users users WHERE users.id=p.user_id) name\n"
          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
          + ", (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
          + ", (SELECT COUNT(*) FROM post_comments pc WHERE pc.post_id=p.id) commentCount\n"
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
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
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
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
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
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
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)
  List<Post> getPostsEarly(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);


  @Query(value =
      "SELECT COUNT(*)\n"
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n",
      nativeQuery = true)
  int getPostsCount(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);


  @Query(value =
      "SELECT  *\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:query% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)
  List<Post> getPostsSearchQuery(@Param("query") String query, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);


  @Query(value =
      "SELECT  COUNT(*)\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:query% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n",
      nativeQuery = true)
  int getPostsSearchQueryCount(@Param("query") String query, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);


  @Query(value =
      "SELECT COUNT(*)\n"
          + "FROM posts p "
          + "WHERE moderation_status= \"NEW\"",
      nativeQuery = true)
  int moderationCount();

  //------------------ Список постов за указанную дату-------

  @Query(value =
      "SELECT  *\n"
          + "FROM posts p "
          + "WHERE date(p.time)= STR_TO_DATE(:dateQuery,GET_FORMAT(DATE,'ISO'))  AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
          + "ORDER BY  p.id",
      nativeQuery = true)
  List<Post> getPostsSearchByDate(@Param("dateQuery") String date, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);

  @Query(value =
      "SELECT  COUNT(*)\n"
          + "FROM posts p "
          + "WHERE date(p.time)= STR_TO_DATE(:dateQuery,GET_FORMAT(DATE,'ISO'))  AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n",
      nativeQuery = true)
  int getPostsSearchByDateCount(@Param("dateQuery") String date, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

  //-----------

  @Query(value =
      "SELECT  *\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:tag% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)
  List<Post> getPostsSearchByTag(@Param("tag") String tag, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus, Pageable pageable);


  @Query(value =
      "SELECT  COUNT(*)\n"
          + "FROM posts p "
          + "WHERE p.text LIKE %:tag% AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n",
      nativeQuery = true)
  int getPostsSearchByTagCount(@Param("tag") String tag, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

//------------------ Calendar-------

  @Query(value =
      "SELECT DISTINCT\n"
          + "year(time) year\n"
          + "FROM posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
          + "ORDER BY year",
      nativeQuery = true)
  List<Integer> getPostsYears(@Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

  @Query(value =
      "SELECT *\n"
          + "FROM posts p "
          + "WHERE year(p.time)= :yearPost AND is_active= :isActive AND moderation_status= :modStatus AND time<= current_timestamp() \n"
          + "ORDER BY  p.time",
      nativeQuery = true)
  List<Post> getPostsForYear(@Param("yearPost") int yearPost, @Param("isActive") int isActive,
      @Param("modStatus") String moderationStatus);

  //-----------Получение поста----------------

  @Query(value =
      "SELECT *\n"
          + "FROM posts p "
          + "WHERE id = :id  \n",
      nativeQuery = true)
  Post getPostById(@Param("id") int id);


  Optional<Post> findById(int id);

  //-----------Получение моих постов inactive----------------


  @Query(value =
      "SELECT * "
          + "FROM posts p "
          + "WHERE user_id = :userId AND is_active= :isActive ",
      nativeQuery = true)
  List<Post> getMyPostsInactive(@Param("userId") int userId, @Param("isActive") int isActive
      , Pageable pageable);

  @Query(value =
      "SELECT count(*) "
          + "FROM posts p "
          + "WHERE user_id = :userId AND is_active= :isActive ",
      nativeQuery = true)
  int getMyPostsInactive(@Param("userId") int userId, @Param("isActive") int isActive
      );

  //-----------Получение моих постов active----------------


  @Query(value =
      "SELECT * "
          + "FROM posts p "
          + "WHERE user_id = :userId AND is_active= :isActive  AND moderation_status= :modStatus ",
      nativeQuery = true)
  List<Post> getMyPostsActive(@Param("userId") int userId
      , @Param("isActive") int isActive
      ,@Param("modStatus") String moderationStatus
      , Pageable pageable);

  @Query(value =
      "SELECT count(*) "
          + "FROM posts p "
          + "WHERE user_id = :userId AND is_active= :isActive  AND moderation_status= :modStatus ",
      nativeQuery = true)
  int getMyPostsActive(@Param("userId") int userId
      , @Param("isActive") int isActive
      ,@Param("modStatus") String moderationStatus
      );

  //-----------Получение постов на модерацию----------------


  @Query(value =
      "SELECT * "
          + "FROM posts p "
          + "WHERE moderation_status='NEW' AND is_active=1 ",
      nativeQuery = true)
  List<Post> getPostsNewToModeration(Pageable pageable);

  @Query(value =
      "SELECT count(*) "
          + "FROM posts p "
          + "WHERE moderation_status='NEW' AND is_active=1 ",
      nativeQuery = true)
  int getPostsNewToModerationCount();

  //-----------Получение постов на модерацию----------------


  @Query(value =
      "SELECT * "
          + "FROM posts p "
          + "WHERE moderator_id  = :userId  AND moderation_status= :modStatus   AND is_active=1 ",
      nativeQuery = true)
  List<Post> getPostsToModeration(@Param("userId") int userId
      ,@Param("modStatus") String moderationStatus
      , Pageable pageable);

  @Query(value =
      "SELECT count(*) "
          + "FROM posts p "
          + "WHERE moderator_id  = :userId  AND moderation_status= :modStatus   AND is_active=1 ",
      nativeQuery = true)
  int getPostsToModerationCount(@Param("userId") int userId
      ,@Param("modStatus") String moderationStatus
      );

  //-----------Получение Статистики----------------


  @Query(value =
      "SELECT count(*)  FROM posts",
      nativeQuery = true)
  int getStatisticsCount();

  @Query(value =
      "SELECT sum(view_count)  FROM posts",
      nativeQuery = true)
  int getStatisticsView();

  @Query(value =
      "SELECT UNIX_TIMESTAMP(min(time))  FROM posts",
      nativeQuery = true)
  long getStatisticsTime();

  @Query(value =
      "SELECT count(*) FROM post_votes where value = 1",
      nativeQuery = true)
  int getStatisticsLikes();

  @Query(value =
      "SELECT count(*) FROM post_votes where value = -1",
      nativeQuery = true)
  int getStatisticsDislikes();

  //-----------Получение My Статистики----------------


  @Query(value =
      "SELECT count(*)  FROM posts "
          + " WHERE id  = :myId ",
      nativeQuery = true)
  int getMyStatisticsCount(@Param("myId") int myId);

  @Query(value =
      "SELECT sum(view_count)  FROM posts "
          + " WHERE id  = :myId ",
      nativeQuery = true)
  int getMyStatisticsView(@Param("myId") int myId);

  @Query(value =
      "SELECT UNIX_TIMESTAMP(min(time))  FROM posts "
          + " WHERE id  = :myId ",
      nativeQuery = true)
  long getMyStatisticsTime(@Param("myId") int myId);

  @Query(value =
      "SELECT count(*) FROM post_votes WHERE value = 1 "
          + " AND id  = :myId ",
      nativeQuery = true)
  int getMyStatisticsLikes(@Param("myId") int myId);

  @Query(value =
      "SELECT count(*) FROM post_votes WHERE value = -1"
          + " AND id  = :myId ",
      nativeQuery = true)
  int getMyStatisticsDislikes(@Param("myId") int myId);


  //--------------Добавление поста-------------

  @Modifying
  @Query(value =
      "INSERT INTO posts "
          + "(is_active, moderation_status, text, time, title, user_id, view_count) "
          + "VALUES (:is_active, :modStatus, :text, :time, :title, :user_id, '0')",
      nativeQuery = true)
  int addPost(@Param("is_active") int isActive,
      @Param("modStatus") String modStatus,
      @Param("text") String text,
      @Param("time") Date time,
      @Param("title") String title,
      @Param("user_id") int userId);

}
