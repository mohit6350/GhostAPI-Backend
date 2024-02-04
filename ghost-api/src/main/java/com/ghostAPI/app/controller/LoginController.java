package com.ghostAPI.app.controller;

import com.ghostAPI.app.requestModel.Login;
import com.ghostAPI.app.service.LoginService;
import com.ghostAPI.app.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public String saveUser(@RequestBody Login loginPojo){
        System.out.println(loginPojo);
        Login flag = loginService.saveUser(loginPojo);
        if(flag != null)
            return flag.toString();
        else
            return "something went wrong";
    }

}
