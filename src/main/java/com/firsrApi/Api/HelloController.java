package com.firsrApi.Api;


import com.firsrApi.Api.APP.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello world";
    }

    //@GetMapping("/user")
    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    public User getUser(){
        return new User(1,"Mohit","mohit@gmail.com");
    }
}
