package com.example.demo.service.impl;

import com.example.demo.domain.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2020/3/13.
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Override
    @Cacheable(
            value = {"dept"},
            cacheNames = "dept"
    )
    public Dept getDept(Integer id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    @Cacheable(
            value = {"deptList"},
            cacheNames = "deptList"
    )
    public List<Dept> getList(Dept dept) {
        return deptMapper.getList(dept);
    }
}
