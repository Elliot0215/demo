package com.example.demo.mapper;

import com.example.demo.domain.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2020/3/12.
 */
@Repository
public interface UserMapper {
    UserInfo getById(Integer id);
}
