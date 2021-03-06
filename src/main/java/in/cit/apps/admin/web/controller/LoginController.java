package in.cit.apps.admin.web.controller;

import in.cit.apps.admin.common.Constants;
import in.cit.apps.admin.exceptions.InvalidUserDataException;
import in.cit.apps.admin.model.LoginData;
import in.cit.apps.admin.model.enums.TemplateEnum;
import in.cit.apps.admin.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Prabhat on 4/18/2017.
 */
@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    /*@Value("${cit.uname:UNKNOWN}")
    private String uname;*/

    @Autowired
    LoginService loginService;

    @RequestMapping(value = {"/", "login"}, method = {RequestMethod.GET})
    public String login(Model model) {
        model.addAttribute("loginData", new LoginData());
        return TemplateEnum.LOGIN.getTemplate();
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(@Validated @ModelAttribute("loginData") LoginData loginData, BindingResult bindingResult, HttpServletRequest request) throws InvalidUserDataException {
        logger.debug("Login userNam" + loginData.getUserName());
        if (bindingResult.hasErrors()) {
            logger.error("Validation eror for user name:"+loginData.getUserName());
            return TemplateEnum.LOGIN.getTemplate();
        }
        loginService.validateLogin(loginData);
        request.getSession(false).setAttribute(Constants.USER_CONTEXT, loginData);
        return TemplateEnum.HOME.getTemplate();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
