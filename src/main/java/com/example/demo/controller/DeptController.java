package com.example.demo.controller;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.example.demo.domain.Dept;
import com.example.demo.domain.User;
import com.example.demo.service.impl.DeptServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2020/3/13.
 */
@Controller
public class DeptController {
    @Value("${hello}")
    private String hello;
    @Autowired
    private DeptServiceImpl service;
    @RequestMapping("/getDept")
    public Dept getDept(@RequestParam("id") Integer id){
        Dept dept = service.getDept(id);
        return dept;
    }

    @PostMapping("/getListDept")
    public List<Dept> getListDept(@RequestBody Dept dept){
        return service.getList(dept);
    }

    @GetMapping("/boot/hello")
    public String hello(){
        return hello;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null){
            subject.logout();
        }
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/demo")
    public String demo(){
        return "demo";
    }

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            HttpSession httpSession){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
            User user = (User)subject.getPrincipal();
            httpSession.setAttribute("user",user);
            return "index";
            //httpServletRequest.getRequestDispatcher("/index").forward(httpServletRequest,httpServletResponse);
        }catch (Exception e){
            //httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);
            return "login";
        }
    }

}
