package com.aiaixyz.jiumanager.entity.bo;

import com.aiaixyz.jiumanager.entity.po.User;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/13
 */
public class UserBo {
    private User user;
    private String sPermit;

    public UserBo(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserBo{" +
                "user=" + user +
                ", sPermit='" + sPermit + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getsPermit() {
        return sPermit;
    }

    public void setsPermit(String sPermit) {
        this.sPermit = sPermit;
    }

    public UserBo(User user, String sPermit) {
        this.user = user;
        this.sPermit = sPermit;
    }

}
