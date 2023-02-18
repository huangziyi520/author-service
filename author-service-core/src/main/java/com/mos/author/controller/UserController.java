package com.mos.author.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getCurrentUser")
    @ResponseBody
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
