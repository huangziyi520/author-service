package com.canteencenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.canteencenter.security.entity.User;
import com.canteencenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/api")
public class TestController implements EnvironmentAware {

    private Environment environment;

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
//    @ResponseBody
    public String test() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setIsDeleted(0);
        user.setUsername("xxx" + System.currentTimeMillis());
        user.setGmtCreate(new Date());
//        userService.createUser(user);
        return "redirect:query/test";
    }

    @RequestMapping("/query/test")
    @ResponseBody
    public String testQuery() {
//        User user = userService.selectById(id);
        return "success";
    }

    @ModelAttribute(value = "testModelName")
    public String testModelAttribute(String test01) {
        return "testModelValue";
    }

    @RequestMapping("/query/{id}")
    @ResponseBody
    public String test(@PathVariable long id) {
        User user = userService.selectById(id);
        return JSONObject.toJSONString(user);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
