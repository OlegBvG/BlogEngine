package main.repositories;

import java.util.Date;
import java.util.List;
import main.model.ModerationStatus;
import main.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//public interface CustomizedPostsCrudRepository extends CrudRepository<Post, Long>, CustomizedPosts<Post> {
//public interface CustomizedPostsCrudRepository extends CrudRepository<Post, Long> {
public interface PostRepository extends JpaRepository<Post, Long> {
//public interface PostRepository extends JpaRepository<PostQuery, Long> {
  @Query(value =
      "SELECT *\n"
          + ", (SELECT u.name FROM blog.users u WHERE u.id=p.user_id) name\n"
          + ", \"Текст аннонса поста без HTML-тегов\" announce\n"
          + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) likeCount\n"
          + ", (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1) dislikeCount\n"
          + ", (SELECT COUNT(*) FROM blog.post_comments pc WHERE pc.post_id=p.id) commentCount\n"
          + "FROM blog.posts p "
          + "WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
          + "ORDER BY likeCount DESC, dislikeCount, p.time DESC",
      nativeQuery = true)


  List<Post> getAllPosts(@Param("isActive") int isActive,  @Param("modStatus") String moderationStatus, @Param("date") Date time);
//  List<PostQuery> getAllPostsQuery(@Param("isActive") int isActive,  @Param("modStatus") String moderationStatus, @Param("date") Date time);


  //  List<Post> getAllPosts(@Param("isActive") int isActive,  @Param("modStatus") String moderationStatus, @Param("date") Date time, Pageable pageable);
//  List<Post> getAllPosts(@Param("isActive") int isActive,  @Param("modStatus") ModerationStatus moderationStatus);
//  ,
  /* List<Object[]> result =  query.list();
  List result = em.createQuery(
"select s. f irstName, s. las tName, "
+ "a.title from Singer s "
+ "left join s.albums а "
+ "where a.releaseDate=(select max(a2.releaseDate) "
+ "from Album а2 where a2.singer.id = s.id)")
.getResultList();
   */
//      @Param("modStatus") ModerationStatus moderationStatus,
//      @Param("date") Date time);
//      ,
//        Pageable pageable);

}
/*
      "SELECT * FROM posts p WHERE is_active= :isActive AND moderation_status= :modStatus AND " +
          "time<= :date ORDER BY (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1)"
          +
          " DESC, (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1), p.time DESC",

SELECT * FROM blog.posts p WHERE is_active= 1 AND moderation_status= 'ACCEPTED' AND time<= '2020-11-23 00:00:00'
ORDER BY (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) DESC, (SELECT COUNT(*)
FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1), p.time DESC;

  @Query(value =
      "SELECT * FROM posts p WHERE is_active= :isActive AND moderation_status= :modStatus AND " +
          "time<= :date ORDER BY (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=1)"
          +
          " DESC, (SELECT COUNT(*) FROM post_votes pv WHERE pv.post_id=p.id AND pv.value=-1), p.time DESC",
      nativeQuery = true)

        List<Post> getAllPosts(@Param("isActive") int isActive,
      @Param("modStatus") ModerationStatus moderationStatus,
      @Param("date") Date time);

@Repository
public interface CustomizedEmployeesCrudRepository extends CrudRepository<Employees, Long>, CustomizedEmployees<Employees> {

    @Query("select e from Employees e where e.salary > :salary")
    List<Employees> findEmployeesWithMoreThanSalary(@Param("salary") Long salary, Sort sort);
    // ...
}

-------------
  @Query(value =
      "SELECT * FROM blog.posts p WHERE is_active= :isActive AND moderation_status= :modStatus AND time<= :date \n"
          + "ORDER BY (SELECT COUNT(*) FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=1) DESC, (SELECT COUNT(*) \n"
          + "FROM blog.post_votes pv WHERE pv.post_id=p.id AND pv.value=-1), p.time DESC",
      nativeQuery = true)

//  List<Post> getAllPosts(@Param("isActive") int isActive,  @Param("modStatus") String moderationStatus, @Param("date") Date time, Pageable pageable);
  List<Post> getAllPosts(@Param("isActive") int isActive,  @Param("modStatus") String moderationStatus, @Param("date") Date time);

 */