package main.repositories;

import java.util.Optional;
import main.model.GlobalSettings;
import org.springframework.data.repository.CrudRepository;

public interface GlobalSettingsCrudRepository extends CrudRepository<GlobalSettings, Long> {

  Optional<GlobalSettings> findByCode(String code);

}
