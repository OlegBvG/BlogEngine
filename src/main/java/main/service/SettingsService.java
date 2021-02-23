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

}
