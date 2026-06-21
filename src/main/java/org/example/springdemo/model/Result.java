package org.example.springdemo.model;

/**
 * 统一响应大盒子，全项目所有接口都可以用它装数据吐给前端
 */
public class Result<T> {
    private int code;       // 200 成功，500 失败
    private String message; // 提示消息
    private T data;         // 真正装计算结果的地方

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    // 快捷 Getter/Setter (IDEA中可通过 Alt+Insert 快速生成，这里为了清爽省略，请记得自己加上哦)
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}