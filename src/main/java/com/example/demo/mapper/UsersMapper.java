package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2020/3/15.
 */
@Repository
public interface UsersMapper {
    User findByUsername(@Param("username") String username);
}
