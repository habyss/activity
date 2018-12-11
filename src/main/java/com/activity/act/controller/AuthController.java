package com.activity.act.controller;

import com.activity.act.entity.Auth;
import com.activity.act.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController extends BaseController {

    @Autowired
    AuthServiceImpl authService;

    @GetMapping("login")
    public String loginView() {
        System.out.println("get---login");
        return "login";
    }

    @PostMapping("login")
    public ResponseEntity<Void> login(@RequestBody Auth auth) {
        if (auth.getUsername() == null || auth.getUsername().length() == 0 || auth.getPassword() == null || auth.getPassword().length() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("post----login");
        System.out.println(auth);
        auth = authService.getAuthInfo(auth);
        if (auth == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            auth.setPassword("");
            setSessionAttr("_user", auth);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("register")
    public String registerView(){
        System.out.println("get---register");
        return "register";
    }
}
