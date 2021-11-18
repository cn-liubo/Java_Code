package com.liu.controller;

import com.liu.exception.AppException;
import com.liu.model.Response;
import com.liu.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public Object login(HttpServletRequest req, @RequestBody User user){
        //模拟数据库验证用户名密码
        if("abc".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            //校验通过，设置session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            return null;
        }
        throw new AppException("USR001", "用户名或密码错误");
    }

    @RequestMapping("/1")
    public Object u1() {
        Response response = new Response();
        response.setCode("1");
        return response;
    }

    @GetMapping("/2")
    public Object u2() {
        User user = new User();
        user.setUsername("zs");
        return user;
    }

    @GetMapping("/3")
    public Object u3() {
        return "u3";
    }

    @GetMapping("/4")
    public String u4() {
        return "u4";
    }

    /**
     * 这样返回字符串作为响应体，会再包装为统一数据格式时报错
     * 避免这种返回即可
     * 正式项目时，提供解决方案
     * @return
     */
    @GetMapping("/5")
    public Object u5() {
        return null;
    }

    @GetMapping("/6")
    public String u6() {
        return null;
    }
}
