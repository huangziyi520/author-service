package com.mos.author.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello security";
    }

    @RequestMapping("/hello01")
    @ResponseBody
    public String hello01(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getContextPath());
        System.out.println("================================");
        return "hello security";
    }
}
