package com.example.day20220824;

import java.io.Serializable;

public class LoginBean implements Serializable {
    private String userid;
    private String passwd;

    public LoginBean() {
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "userid='" + userid + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public LoginBean(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
