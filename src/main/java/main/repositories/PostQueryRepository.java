package main.repositories;

//import java.util.Date;
//import java.util.List;
//import main.model.Post;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
//import org.springframework.data.repository.RepositoryDefinition;
//import org.springframework.data.repository.query.Param;
//
//@org.springframework.stereotype.Repository
//
//public interface PostQueryRepository extends Repository<PostQuery, Long> {
//
//  @Query(value =
//      "SELECT *\n"
//          + ", (SELECT u.name FROM blog.users u WHERE u.id=p.user_id) name\n"
//          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
//          + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
//          + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
//          + ", (SELECT COUNT(*) FROM blog.post_comments pc WHERE pc.post_id=p.id) commentCount\n"
//          + "FROM blog.posts p "
//          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
//          + "ORDER BY likeCount DESC, dislikeCount, p.time DESC",
//      nativeQuery = true)
//  List<PostQuery> getAllPostsQuery(@Param("isActive") int isActive,  @Param("modStatus") String moderationStatus, @Param("date") Date time);
//
//
//}
