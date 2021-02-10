package main.service;

import main.api.response.SettingsResponse;
import main.repositories.GlobalSettingsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettingsService {

  @Autowired
  private GlobalSettingsCrudRepository globalSettingsCrudRepository;


  //  //  @Query("SELECT value FROM blog.global_settings gs WHERE gs.code=MULTIUSER_MODE")
//  @Query("SELECT * FROM blog.global_settings gs ")
//  Collection<GlobalSettings> globalSettings() {
//
//    return globalSettings();
//  }
//  @Query(value = "SELECT * FROM blog.global_settings", nativeQuery = true)
//  Collection<GlobalSettings> globalSettings() {
//    return globalSettings();
//  }
  @Transactional
  public SettingsResponse getGlobalSettings() {
    SettingsResponse settingsResponse = new SettingsResponse();
//    settingsResponse.setMultiuserMode(true);
    settingsResponse.setMultiuserMode(
        globalSettingsCrudRepository.findByCode("MULTIUSER_MODE").get().getValue().equals("YES"));
    settingsResponse.setPostPremoderation(
        globalSettingsCrudRepository.findByCode("POST_PREMODERATION").get().getValue()
            .equals("YES"));
    settingsResponse.setStatisticsIsPublic(
        globalSettingsCrudRepository.findByCode("STATISTICS_IS_PUBLIC").get().getValue()
            .equals("YES"));

//    settingsResponse.setStatisticsIsPublic(true);
//    @Query("SELECT u FROM User u WHERE u.status = 1")
//    settingsResponse.setStatisticsIsPublic(true);

    System.out.println("gs");
//    System.out.println(globalSettings().size());

    return settingsResponse;
  }

}
/*
@Service
public class EmployeesDataService {

 @Autowired
 private CustomizedEmployeesCrudRepository employeesCrudRepository;

  @Transactional
  public void testEmployeesCrudRepository() {
	Optional<Employees> employeesOptional = employeesCrudRepository.findById(127L);
	//....
    }
 */