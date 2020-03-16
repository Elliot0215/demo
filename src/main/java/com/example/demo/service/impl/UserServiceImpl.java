package com.example.demo.service.impl;

import com.example.demo.domain.UserInfo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/3/12.
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    @Cacheable(value = {"userinfo"},cacheNames = "userinfo")
    public UserInfo getUser(Integer id) {
        return userMapper.getById(id);
    }
}
