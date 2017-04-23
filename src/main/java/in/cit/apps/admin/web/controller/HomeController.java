package in.cit.apps.admin.web.controller;

import in.cit.apps.admin.model.enums.TemplateEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Prabhat on 4/18/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home")
    public String home() {
        return TemplateEnum.ONBOARD.getTemplate();
    }

    @RequestMapping(value = "/onboard")
    public String onboard() {
        return TemplateEnum.ONBOARD.getTemplate();
    }

    @RequestMapping(value = "/financial")
    public String finacial() {
        return TemplateEnum.FINANCE.getTemplate();
    }
}
