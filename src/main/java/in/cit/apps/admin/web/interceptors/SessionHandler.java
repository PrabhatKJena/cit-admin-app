package in.cit.apps.admin.web.interceptors;

import in.cit.apps.admin.common.Constants;
import in.cit.apps.admin.web.controller.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Prabhat on 4/23/2017.
 */
public class SessionHandler extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(SessionHandler.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerObj = (HandlerMethod) handler;
        logger.debug("Invoked request path:: {}", handlerObj.getMethod().getName());
        // if Request not for "/login"
        if (!Constants.LOGIN_PATH.equals(handlerObj.getMethod().getName())) {
            Object userContext = request.getSession().getAttribute(Constants.USER_CONTEXT);
            if (userContext == null)
                return false;
        }
        return true;
    }
}
