package in.cit.apps.admin.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Prabhat on 4/18/2017.
 */
@Controller
public class LoginController {
    @Value("${cit.uname:UNKNOWN}")
    private String uname;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login(Map<String, String> model) {
        model.put("uname", uname);
        return "Login";
    }

}
