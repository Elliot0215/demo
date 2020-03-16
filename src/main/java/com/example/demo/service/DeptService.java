package com.example.demo.service;

import com.example.demo.domain.Dept;

import java.util.List;

/**
 * Created by Administrator on 2020/3/13.
 */
public interface DeptService {
    Dept getDept(Integer id);
    List<Dept> getList(Dept dept);
}
