package com.activity.act.controller;

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
import java.util.List;
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
    public String testGet(Map<String, Object> map) throws IOException {
        restTemplate.setInterceptors(Collections.singletonList(new UserAgentInterceptor()));
        String url = "https://api.warframestat.us/pc/cetusCycle";
        String json = restTemplate.getForEntity(url, String.class).getBody();
        System.out.println("json ------------>"+json);
        HashMap<String, Object> test = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        test = mapper.readValue(json, test.getClass());
//        System.out.println(map);
        System.out.println(test.get("timeLeft"));
        map.put("test",test);
        System.out.println(map);
        System.out.println(test);
        return "test";
    }

    @GetMapping("/getApi1")
    public ResponseEntity<String> testGetApi1(){
        restTemplate.setInterceptors(Collections.singletonList(new UserAgentInterceptor()));
        String url = "https://api.warframestat.us/pc/cetusCycle";
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        System.out.println(entity.getBody());
        System.out.println(entity);
        return entity;
    }
}
