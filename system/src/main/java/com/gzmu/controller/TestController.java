package com.gzmu.controller;


import com.gzmu.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class TestController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private TestService testService;

    @RequestMapping("/getSystem")
    public String getSystem(){
        return "hello, I am system module，port：" + port;
    }

    @RequestMapping("/getUser")
    public String getUser(){
        return testService.getUser();
    }

}
