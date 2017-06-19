package com.lccf.service.user;

import com.lccf.service.base.PageParam;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author lichangchao
 * @Time 2017 -04-13 20:22:31
 */
public class UserParam extends PageParam implements Serializable {
    private Long id;
    private String userName;

    private String realName;

    private String email;

    private String mobile;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
