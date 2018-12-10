package com.activity.act.controller;

import com.activity.act.DO.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @GetMapping("login")
    public String login(){
        System.out.println("get---login");
        return "login";
    }

    @PostMapping("login")
    public String auth(@RequestBody Auth auth, HttpServletRequest request, Model mv){
        System.out.println("post----login");
        System.out.println(auth);
        if ("username".equals(auth.getUsername()) && "password".equals(auth.getPassword())){
            mv.addAttribute("auth",auth);
            request.getSession().setAttribute("_user",auth);
            return "index";
        }else {
            mv.addAttribute("msg","错误");
            return "getApi";
        }
    }
}
