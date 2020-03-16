package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/3/15.
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    @Override
    public User findByUsername(String username) {
        return usersMapper.findByUsername(username);
    }
}
