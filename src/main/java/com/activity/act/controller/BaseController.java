package com.activity.act.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @Autowired
    HttpServletRequest request;

    protected void setSessionAttr(String key,Object value){
        request.getSession().setAttribute(key,value);
    }
    protected Object getSessionAttr(String key){
        return request.getSession().getAttribute(key);
    }
}
