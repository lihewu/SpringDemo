package org.example.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("param")
public class ParamsController {
    @RequestMapping("m1")
    public String method1(String name){
        return "接收到的参数名:"+name;
    }
    @RequestMapping("m2")
    public String method2(String name,String password) {
        return "用户名:"+name+",密码"+password;
    }

    @RequestMapping("m3")
    public String metho3(String[] arraysParam) {
        return "接收到的数组值"+ Arrays.toString(arraysParam);
    }
}
