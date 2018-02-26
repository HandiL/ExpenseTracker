package com.handi.expensetracker.Entity;

/**
 * Created by Handi on 2/26/2018.
 */

public class UserData {
    private int status;
    private String msg;
    private User user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
