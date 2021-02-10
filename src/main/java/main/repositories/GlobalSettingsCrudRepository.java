package main.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import main.model.GlobalSettings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GlobalSettingsCrudRepository extends CrudRepository<GlobalSettings, Long>{
//, CustomizedEmployees<Employees>
Optional<GlobalSettings> findByCode(String code);

//    @Query("SELECT * FROM blog.global_settings gs ")
//    Collection<GlobalSettings> globalSettings();

//      @Query(value = "SELECT value FROM blog.global_settings gs", nativeQuery = true)
//      List<GlobalSettings> globalSettings(@Param("MULTIUSER_MODE") boolean multiuserMode) ;
      /*
      @Query("select e from Employees e where e.salary > :salary")
    List<Employees> findEmployeesWithMoreThanSalary(@Param("salary") Long salary, Sort sort);
       */
}
