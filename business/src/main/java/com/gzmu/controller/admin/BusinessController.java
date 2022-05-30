package com.gzmu.controller.admin;


import com.gzmu.server.service.ChapterService;
import com.gzmu.server.view.ChapterView;
import com.gzmu.server.view.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台访问controller层
 */
@RestController
@RequestMapping("business/admin")
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
    public PageModel<ChapterView> getUser(PageModel pageModel){
        return businessService.list(pageModel);
    }

}
