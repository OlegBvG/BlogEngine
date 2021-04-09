package main.repositories;

import java.util.List;
import java.util.Optional;
import main.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TagRepository extends JpaRepository<Tags, Long> {

  @Query(value =
      "SELECT *\n"
          + "FROM tags t "
          + "ORDER BY  t.name",
      nativeQuery = true)
  List<Tags> getTags();

  Optional<Tags> findByName(String name);

  @Modifying
  @Query(value =
      "INSERT INTO tags "
          + "(name) "
          + "VALUES (:name)",
      nativeQuery = true)
  void addTag(@Param("name") String name);

}
