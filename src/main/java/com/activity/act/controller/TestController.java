package com.activity.act.controller;

import com.activity.act.VO.CetusCycle;
import com.activity.act.interceptor.UserAgentInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("test")
    public String test() {
        return "index";
    }

    /***********HTTP GET method*************/

    @GetMapping("/getApi")
    public String testGet(Model model) throws IOException {
        restTemplate.setInterceptors(Collections.singletonList(new UserAgentInterceptor()));
        String url = "https://api.warframestat.us/pc/cetusCycle";
        String json = restTemplate.getForEntity(url, String.class).getBody();
        System.out.println("json ---" + json);

        Map map = new HashMap<>();
        map = new ObjectMapper().readValue(json, map.getClass());
        model.addAttribute("map",map);
        return "test";
    }

    @GetMapping("/getApi1")
    public String testGetBean(Model model) throws IOException {
        restTemplate.setInterceptors(Collections.singletonList(new UserAgentInterceptor()));
        String url = "https://api.warframestat.us/pc/cetusCycle";
        String json = restTemplate.getForEntity(url, String.class).getBody();
        System.out.println("json ---" + json);

        CetusCycle cetusCycle = new CetusCycle();
        cetusCycle = new ObjectMapper().readValue(json, cetusCycle.getClass());
        model.addAttribute("ce",cetusCycle);
        return "test";
    }
}
