package org.example.springdemo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class RouteController {


    @GetMapping("/login")
    public void toLoginPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login.html");
    }

    // 🎯 核心魔法：监听浏览器输入的 /calc（不带任何后缀）
    @GetMapping("/calc")
    public void toCalcPage(HttpServletResponse response) throws IOException {
        // 当用户访问 /calc 时，在后台悄悄把他重定向推给真实的静态文件 /calc.html
        response.sendRedirect("/calc.html");
    }
}