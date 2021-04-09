package main.controller;

import static java.time.LocalDate.now;

import main.api.response.CalendarResponse;
import main.api.response.InitResponse;
import main.api.response.SettingsResponse;
import main.api.response.StatisticsResponse;
import main.api.response.TagResponse;
import main.service.CalendarService;
import main.service.PostService;
import main.service.SettingsService;
import main.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

  private SettingsService settingsService;
  private final InitResponse initResponse;
  private TagService tagService;
  private CalendarService calendarService;
  private PostService postService;


  public ApiGeneralController(SettingsService settingsService,
      InitResponse initResponse, TagService tagService, CalendarService calendarService,
      PostService postService) {
    this.settingsService = settingsService;
    this.initResponse = initResponse;
    this.tagService = tagService;
    this.calendarService = calendarService;

    this.postService = postService;
  }

  @GetMapping("/settings")
  private SettingsResponse settings() {

    return settingsService.getGlobalSettings();
  }

  @PutMapping("/settings")
  private void settingsSave(@RequestBody SettingsResponse settingsResponse) {
    boolean multiUserMode = settingsResponse.isMultiuserMode();
    boolean postPremoderation = settingsResponse.isPostPremoderation();
    boolean statisticsIsPublic = settingsResponse.isStatisticsIsPublic();

    settingsService.saveGlobalSettings(multiUserMode, postPremoderation, statisticsIsPublic);
  }


  @GetMapping("/init")
  private InitResponse init() {

    return initResponse;
  }

  @GetMapping("/tag")
  private TagResponse tagResponse() {
    return tagService.getTags();

  }

  @GetMapping("/calendar")
  private CalendarResponse calendarResponse(@RequestParam(name = "year") String year) {

    int yearParameter =
        year.trim().length() == 0 ? Integer.parseInt(String.valueOf(now().getYear()))
            : Integer.parseInt(year);

    return calendarService.getCalendar(yearParameter);

  }

  @GetMapping("/statistics/all")
  private ResponseEntity<?> statisticsResponse() {

    return postService.getStatistics();

  }

  @GetMapping("/statistics/my")
  private StatisticsResponse myStatisticsResponse() {

    return postService.getMyStatistics();
  }

}



