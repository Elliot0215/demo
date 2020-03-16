package com.example.demo.service;

import com.example.demo.domain.User;

/**
 * Created by Administrator on 2020/3/15.
 */
public interface UsersService {
    User findByUsername(String username);
}
