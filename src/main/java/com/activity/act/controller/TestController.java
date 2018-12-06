package com.activity.act.controller;

import com.activity.act.DO.WarframeDictionary;
import com.activity.act.VO.CetusCycle;
import com.activity.act.interceptor.UserAgentInterceptor;
import com.activity.act.service.impl.WarframeDictionaryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WarframeDictionaryServiceImpl warframeDictionaryServiceImpl;

    @PostMapping("in")
    public ResponseEntity insert(@RequestBody List<WarframeDictionary> wf){
        System.out.println(wf.size());
        warframeDictionaryServiceImpl.insert(wf);
        return ResponseEntity.ok(wf);
    }

    @GetMapping("search")
    public ResponseEntity search(){
        List<WarframeDictionary> search = warframeDictionaryServiceImpl.findByZhLike("致残");
        return ResponseEntity.ok(search);
    }

    @GetMapping("test")
    public String test() {
        return "index";
    }

    @GetMapping("getApi")
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
