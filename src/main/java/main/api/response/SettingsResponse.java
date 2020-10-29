package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingsResponse {
  @JsonProperty("MULTIUSER_MODE")
  private boolean multiuserMode;
  @JsonProperty("POST_PREMODERATION")
  private boolean postPremoderation;
  @JsonProperty("STATISTICS_IS_PUBLIC")
  private boolean statisticsIsPublic;

  public boolean isMultiuserMode() {
    return multiuserMode;
  }

  public void setMultiuserMode(boolean multiuserMode) {
    this.multiuserMode = multiuserMode;
  }

  public boolean isPostPremoderation() {
    return postPremoderation;
  }

  public void setPostPremoderation(boolean postPremoderation) {
    this.postPremoderation = postPremoderation;
  }

  public boolean isStatisticsIsPublic() {
    return statisticsIsPublic;
  }

  public void setStatisticsIsPublic(boolean statisticsIsPublic) {
    this.statisticsIsPublic = statisticsIsPublic;
  }
}

/*
Получение настроек - GET /api/settings/
Метод возвращает глобальные настройки блога из таблицы global_settings.

Авторизация: не требуется

Формат ответа:

{
 	"MULTIUSER_MODE": false,
	"POST_PREMODERATION": true,
	"STATISTICS_IS_PUBLIC": true
}
 */