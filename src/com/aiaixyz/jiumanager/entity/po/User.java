package com.aiaixyz.jiumanager.entity.po;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class User {
    private Integer uId;
    private String uUsername;
    private String uPassword;
    private String uRealname;
    private Integer uPermit;

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uUsername='" + uUsername + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uRealname='" + uRealname + '\'' +
                ", uPermit='" + uPermit + '\'' +
                '}';
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuRealname() {
        return uRealname;
    }

    public void setuRealname(String uRealname) {
        this.uRealname = uRealname;
    }

    public Integer getuPermit() {
        return uPermit;
    }

    public void setuPermit(Integer uPermit) {
        this.uPermit = uPermit;
    }

    public User() {
    }

    public User(Integer uId, String uUsername, String uPassword, String uRealname, Integer uPermit) {
        this.uId = uId;
        this.uUsername = uUsername;
        this.uPassword = uPassword;
        this.uRealname = uRealname;
        this.uPermit = uPermit;
    }
}
