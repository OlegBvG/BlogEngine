package main.repositories;

import java.util.Optional;
import main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  Optional<User> findByCode(String code);

  Optional<User> findById(int id);

  @Modifying
  @Query(value =
      "INSERT INTO users "
          + "(email, is_moderator, name, password, reg_time) "
          + "VALUES (:email, '0', :name, :password, now())",
      nativeQuery = true)
  int addUser(@Param("email") String email,
      @Param("name") String name,
      @Param("password") String password);

}
