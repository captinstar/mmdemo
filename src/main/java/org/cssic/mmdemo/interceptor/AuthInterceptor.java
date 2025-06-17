package org.cssic.mmdemo.interceptor;

import org.cssic.mmdemo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Component
    public class AuthInterceptor implements HandlerInterceptor {
        private static final String USER_SESSION_ATTRIBUTE = "user";
        private static final String LOGIN_PAGE_URL = "/login";

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            // ... 其余代码保持不变
        }

        // ... 其余方法保持不变
    }
}