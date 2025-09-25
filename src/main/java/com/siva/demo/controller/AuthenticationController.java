package com.siva.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

//userservice

    @Autowired
    UserService userService;
// siva
    @GetMapping("/public")
    public String publicAPi(){
        System.out.println("Inside public method : "+Thread.currentThread().getName());
        userService.asyncMethod();
        return "This is Public Api";
    }

    @GetMapping("/private")
    public String privateApi(){
        return "Authenticated";
    }
    

    @GetMapping("/fetch")
    public String getUserDetails(){
        return "fetching and returning user details";
    }


    @Async
    public void asyncMethod(){
        System.out.println("Inside async method : "+Thread.currentThread().getName());
    }

}
