package in.cit.apps.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Prabhat on 4/18/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/onboard")
    public String onboard() {
        return "onboard";
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }
}
