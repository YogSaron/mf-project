package com.company.project.utils.beans;

import java.io.Serializable;

/**
 * Created by Logan on 2018/7/20.
 */
public class LoginBean implements Serializable {

    private String username ;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
