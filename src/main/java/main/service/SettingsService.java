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

  @Autowired
  public AuthService authService;


  @Transactional
  public SettingsResponse getGlobalSettings() {
    SettingsResponse settingsResponse = new SettingsResponse();
    settingsResponse.setMultiuserMode(
        globalSettingsCrudRepository.findByCode("MULTIUSER_MODE").get().getValue()
            .equals("YES"));
    settingsResponse.setPostPremoderation(
        globalSettingsCrudRepository.findByCode("POST_PREMODERATION").get().getValue()
            .equals("YES"));
    settingsResponse.setStatisticsIsPublic(
        globalSettingsCrudRepository.findByCode("STATISTICS_IS_PUBLIC").get().getValue()
            .equals("YES"));

    return settingsResponse;
  }

  @Transactional
  public void saveGlobalSettings(
      boolean multiUserMode, boolean postPremoderation, boolean statisticsIsPublic) {

    if (authService.isCurrentUserModerator()) {
      globalSettingsCrudRepository.findByCode("MULTIUSER_MODE").get()
          .setValue(multiUserMode ? "YES" : "NO");
      globalSettingsCrudRepository.findByCode("POST_PREMODERATION").get()
          .setValue(postPremoderation ? "YES" : "NO");
      globalSettingsCrudRepository.findByCode("STATISTICS_IS_PUBLIC").get()
          .setValue(statisticsIsPublic ? "YES" : "NO");
    }
  }

}
