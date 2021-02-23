package main.repositories;

import java.util.List;
import main.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagRepository extends JpaRepository<Tags, Long> {

  @Query(value =
      "SELECT *\n"
          + "FROM tags t "
          + "ORDER BY  t.name",
      nativeQuery = true)
  List<Tags> getTags();

}
