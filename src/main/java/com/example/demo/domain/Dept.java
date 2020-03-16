package com.example.demo.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/13.
 */
public class Dept implements Serializable {
    private Integer did;
    private String dname;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
