package org.example.springdemo.controller;

import org.example.springdemo.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController          // 1. 战略定位：我是纯数据（JSON）提供者
@RequestMapping("/api/calc") // 2. 大门牌号：所有计算相关的操作都来这里
public class CalcController {

    // 实际寻址路径：GET /calc/add
    // 语义：查询/获取两个数的相加结果，所以使用安全幂等的 @GetMapping
    @GetMapping("/add")
    public Result<Integer> add(Integer num1, Integer num2) {
        // 3. 简单的防御性编程，防止前端乱传 null
        if (num1 == null || num2 == null) {
            Result<Integer> failResult = new Result<>();
            failResult.setCode(500);
            failResult.setMessage("参数不能为空");
            return failResult;
        }
        // 4. 执行核心加法业务逻辑
        int sum = num1 + num2;

        // 5. 将结果塞进规范的 Result 大盒子，安全返还给前端
        return Result.success(sum);
    }
}