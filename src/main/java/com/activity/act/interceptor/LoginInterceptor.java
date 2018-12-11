package com.activity.act.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    final String login = "/login";
    final String static_ = "/static";
    final String register = "/register";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);
        System.out.println(request.getSession().getAttribute("_user"));
        if (login.equals(uri) || register.equals(uri)){
            return true;
        }
        if (uri.length() > 7 && uri.substring(0,7).equals(static_)){
            return true;
        }
        if (request.getSession().getAttribute("_user") == null){
            response.sendRedirect("login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
