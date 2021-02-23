package main.controller;

import static java.time.LocalDate.now;

import main.api.response.CalendarResponse;
import main.api.response.InitResponse;
import main.api.response.SettingsResponse;
import main.api.response.TagResponse;
import main.service.CalendarService;
import main.service.SettingsService;
import main.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

  private final SettingsService settingsService;
  private final InitResponse initResponse;
  private TagService tagService;
  private CalendarService calendarService;

  public ApiGeneralController(SettingsService settingsService,
      InitResponse initResponse, TagService tagService, CalendarService calendarService) {
    this.settingsService = settingsService;
    this.initResponse = initResponse;
    this.tagService = tagService;
    this.calendarService = calendarService;
  }

  @GetMapping("/settings")
  private SettingsResponse settings() {
    return settingsService.getGlobalSettings();
  }

  @GetMapping("/init")
  private InitResponse init() {
//  private InitResponse init(@RequestBody InitResponse initResponse){

    return initResponse;
  }

  @GetMapping("/tag")
  private TagResponse tagResponse(){
    return tagService.getTags();

  }

  @GetMapping("/calendar")
  private CalendarResponse calendarResponse(@RequestParam(name = "year") String year){

    int yearParameter = year.trim().length()==0 ? Integer.parseInt(String.valueOf(now().getYear())) : Integer.parseInt(year);

    return calendarService.getCalendar(yearParameter);

  }
}
