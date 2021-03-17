package main.controller;

import main.api.response.InitResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

  private final InitResponse initResponse;

  public DefaultController(InitResponse initResponse) {
    this.initResponse = initResponse;
  }

  @GetMapping(value = "/")
  public String index() {
    System.out.println(initResponse.getTitle());

    return "index";
  }


  @RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.GET}, value = "/**/{path:/")
  public String redirectToIndex(){
      return "/forward:/";
  }


}


/*
@Controller
public class DefaultController
{
    private final InitResponse initResponse;

    public DefaultController(InitResponse initResponse) {
        this.initResponse = initResponse;
    }


    @RequestMapping("/")
    public String index(Model model)
    {
        System.out.println(initResponse.getTitle());

        return "index";
    }
}
 */