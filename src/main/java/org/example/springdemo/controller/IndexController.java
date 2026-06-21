package org.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

////@RestController //如果直接使用@RestController，会直接吧"/calc.html"当作json文件
//@Controller
//public class IndexController {
//    @RequestMapping("index")
//    public String index(){
//        return "/calc.html";
//    }
//}


@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index() {//ModelAndView，取消json格式转换
        // 🎯 核心大招：构造一个视图跳转对象，直接指向 /calc.html 页面
        return new ModelAndView("redirect:/index.html");
    }
}