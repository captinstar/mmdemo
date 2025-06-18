package org.cssic.mmdemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
        private static final String USER_SESSION_ATTRIBUTE = "user";
        private static final String LOGIN_PAGE_URL = "/login";

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                HttpSession session = request.getSession(false);
                if (session == null || session.getAttribute(USER_SESSION_ATTRIBUTE) == null) {
                        response.sendRedirect(LOGIN_PAGE_URL);
                        return false;

                }

                return true;
        }
}