package com.myapp.app.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import
 org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.app.entity.User;
import com.myapp.app.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    
    @Resource(name="userService")
    private IUserService userService;

    @RequestMapping(value = "/register",method=RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("administrator")
    public boolean register(User user){
        return userService.register(user);
    }
    
}