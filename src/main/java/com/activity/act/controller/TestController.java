package com.activity.act.controller;

import com.activity.act.entity.WarframeDictionary;
import com.activity.act.vo.CetusCycle;
import com.activity.act.interceptor.UserAgentInterceptor;
import com.activity.act.service.impl.WarframeDictionaryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public ResponseEntity search(@Param(value = "search") String search){
        List<WarframeDictionary> searchResult = warframeDictionaryServiceImpl.findByZhLike("北国霜降寒雪飞,魔都雾起冬雨落%" + search + "%");
         return ResponseEntity.ok(searchResult);
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
        System.out.println("getApi..");
        return "index";
    }
}
