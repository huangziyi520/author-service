package com.mos.author.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        //在此处做下判断，每次登陆的时候判断是否登陆过了
        return "redirect:login.html";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        //在此处做下判断，每次登陆的时候判断是否登陆过了
        return "success";
    }

    @RequestMapping(value = "/loginIndex", method = RequestMethod.POST)
    @ResponseBody
    public String loginIndex() {
        //进行参数校验
        return "redirect:author-service/main.html";
    }

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.POST)
    public String loginSuccess() {
        return "redirect:main.html";
    }

    @RequestMapping(value = "/toError", method = RequestMethod.POST)
    public String loginError() {
        return "redirect:error.html";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:index.html";
    }

}
