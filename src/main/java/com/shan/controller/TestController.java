package com.shan.controller;


import com.shan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用于测试类
@RestController
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping("/test")
    public void test() {
        testService.testTransactional();

    }


}
