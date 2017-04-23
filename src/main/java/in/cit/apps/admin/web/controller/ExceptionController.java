package in.cit.apps.admin.web.controller;

import in.cit.apps.admin.common.Constants;
import in.cit.apps.admin.exceptions.InvalidUserDataException;
import in.cit.apps.admin.model.enums.TemplateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Prabhat on 4/23/2017.
 */
@ControllerAdvice
public class ExceptionController {

    @Autowired
    private LoginController loginController;

    @ExceptionHandler(InvalidUserDataException.class)
    public String invalidUser(Model model, HttpServletRequest request, Exception ex) {
        model.addAttribute(Constants.ERROR_MSG, ex.getMessage());
        return loginController.login(model);
    }

    // Specify name of a specific view that will be used to display the error:
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public String databaseError() {
        // Nothing to do.  Returns the logical view name of an error page, passed
        // to the view-resolver(s) in usual way.
        // Note that the exception is NOT available to this view (it is not added
        // to the model) but see "Extending ExceptionHandlerExceptionResolver"
        // below.
        return TemplateEnum.ERROR.getTemplate();
    }

    // Total control - setup a model and return the view name yourself. Or
    // consider sub classing ExceptionHandlerExceptionResolver (see below).
    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        //logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        System.err.println("Request: " + req.getRequestURL() + " raised " + ex);
        return TemplateEnum.ERROR.getTemplate();
    }

}
