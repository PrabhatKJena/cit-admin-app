package in.cit.apps.admin.web.controller;

import in.cit.apps.admin.exceptions.InvalidUserDataException;
import in.cit.apps.admin.model.LoginData;
import in.cit.apps.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Prabhat on 4/18/2017.
 */
@Controller
public class LoginController {

    /*@Value("${cit.uname:UNKNOWN}")
    private String uname;*/

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String login(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(@ModelAttribute("loginData") LoginData loginData, BindingResult bindingResult) {
        System.out.println(loginData);
        try {
            loginService.validateLogin(loginData);
            return "home";
        } catch (InvalidUserDataException e) {
            System.out.println(e);
            return null;
        }
    }
}
