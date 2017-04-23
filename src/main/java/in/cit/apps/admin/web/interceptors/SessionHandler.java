package in.cit.apps.admin.web.interceptors;

import in.cit.apps.admin.common.Constants;
import in.cit.apps.admin.web.controller.LoginController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Prabhat on 4/23/2017.
 */
public class SessionHandler extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerObj = (HandlerMethod) handler;

        // if Request not for "/login"
        if (!Constants.LOGIN_PATH.equals(handlerObj.getMethod().getName())) {
            Object userContext = request.getSession().getAttribute(Constants.USER_CONTEXT);
            if (userContext == null)
                return false;
        }
        return true;
    }
}
