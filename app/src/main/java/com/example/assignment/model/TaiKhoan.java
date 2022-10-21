package com.example.assignment.model;

public class TaiKhoan {
    private String user;
    private String password;
    private int avatar;

    public TaiKhoan() {
    }

    public TaiKhoan(String user, String password, int avatar) {
        this.user = user;
        this.password = password;
        this.avatar = avatar;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
