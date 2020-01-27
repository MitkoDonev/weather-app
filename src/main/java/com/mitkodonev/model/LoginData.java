package com.mitkodonev.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginData {

    @NotNull
    @Size(min = 6)
    private String userName;

    @NotNull
    @Size(min = 8)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
