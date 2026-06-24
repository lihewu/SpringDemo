package org.example.springdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.springdemo.model.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    // 模拟数据库里的真实账号和密码
    private static final String REAL_USERNAME = "admin";
    private static final String REAL_PASSWORD = "123";

    /**
     * 接口 1: 登录逻辑
     * POST /user/login
     */
    @PostMapping("/login")
    public Result<Boolean> login(String username, String password, HttpServletRequest request) {
        // 1. 校验密码是否正确
        if (REAL_USERNAME.equals(username) && REAL_PASSWORD.equals(password)) {
            // 2. 校验成功，召唤 Session 机制给用户“盖章”！
            // request.getSession() 会自动在服务器内存中开辟一个专属这个用户的空间
            HttpSession session = request.getSession();
            // 把登录的账号放进这块空间里保存起来，起名叫 "LOGIN_USER"
            session.setAttribute("LOGIN_USER", username);
            
            return Result.success(true); // 返回成功
        }
        
        // 3. 校验失败，返回错误信息给前端告知
        return Result.error(400, "账号或密码输入错误！");
    }

    /**
     * 接口 2: 获取当前登录用户信息
     * GET /user/current
     */
    @GetMapping("/current")
    public Result<String> getCurrentUser(HttpServletRequest request) {
        // 去找有没有这个用户的 Session。参数 false 代表如果之前没盖过章，别瞎创建，直接返回 null
        HttpSession session = request.getSession(false); 
        
        if (session != null) {
            // 从 Session 空间里把我们之前存的名字拿出来
            String username = (String) session.getAttribute("LOGIN_USER");
            if (username != null) {
                return Result.success(username); // 成功拿到当前用户
            }
        }
        
        // 如果上面没拿到，说明该用户根本没登录过，按照需求返回空即可
        return Result.success(null);
    }
}