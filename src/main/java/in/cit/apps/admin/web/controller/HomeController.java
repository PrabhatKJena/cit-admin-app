package in.cit.apps.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Prabhat on 4/18/2017.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    @ResponseBody
    public String hello() {
        return "Welcome";
    }
}
