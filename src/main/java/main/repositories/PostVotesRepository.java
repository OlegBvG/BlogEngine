package main.repositories;

import java.util.Optional;
import main.model.PostVotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional

public interface PostVotesRepository extends JpaRepository<PostVotes, Long>{

  Optional<PostVotes> findByPostIdAndUserId(int postId, int userId);

}


