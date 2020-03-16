package com.example.demo.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/12.
 */
public class UserInfo implements Serializable {
    private Integer pid;
    private String pname;
    private Integer age;
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
