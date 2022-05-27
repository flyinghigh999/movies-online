package com.gzmu.controller;


import com.gzmu.server.entity.ChapterEntity;
import com.gzmu.server.entity.TestEntity;
import com.gzmu.server.service.ChapterService;
import com.gzmu.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ChapterService businessService;

    @RequestMapping("/getSystem")
    public String getSystem(){
        return "hello, I am system module，port：" + port;
    }

    @RequestMapping("/list")
    public List<ChapterEntity> getUser(){
        return businessService.list();
    }

}
