package org.example.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//告诉浏览器这是一个controller，并且返回数据类型为 json
public class UserController {
    @RequestMapping("/hello")
    public String sayHi(){
        return "hello,Spring MVC";
    }
}
