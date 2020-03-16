package com.example.demo.mapper;

import com.example.demo.domain.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/3/13.
 */
@Repository
public interface DeptMapper {
    Dept getDeptById(@Param("did") Integer id);
    List<Dept> getList(Dept dept);
}
