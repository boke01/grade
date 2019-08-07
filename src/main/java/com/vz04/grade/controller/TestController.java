package com.vz04.grade.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author vz04
 * @date 8/1/2019 5:36 PM
 **/
@RestController
public class TestController {

    @PostMapping("/test")
    public void test(@RequestBody String id, HttpSession session){
        System.out.println(id);
    }
}
