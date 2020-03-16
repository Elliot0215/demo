package com.example.demo.controller;

import com.example.demo.domain.UserInfo;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/3/12.
 */
@RestController
public class UserController {
    @Resource
    private UserServiceImpl userService;

    @GetMapping("/getUser")
    public UserVo getUser(@RequestParam("id") Integer id){
        UserVo userVo = new UserVo();
        UserInfo user = userService.getUser(id);
        userVo.setCode("common-200");
        userVo.setMsg("查询成功");
        userVo.setUser(user);
        return userVo;
    }
}
