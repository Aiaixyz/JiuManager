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

    public User(Integer uId, String uUsername, String uPassword, String uRealname) {
        this.uId = uId;
        this.uUsername = uUsername;
        this.uPassword = uPassword;
        this.uRealname = uRealname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uUsername='" + uUsername + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uRealname='" + uRealname + '\'' +
                ", uPermit=" + uPermit +
                '}';
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUUsername() {
        return uUsername;
    }

    public void setUUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getURealname() {
        return uRealname;
    }

    public void setURealname(String uRealname) {
        this.uRealname = uRealname;
    }

    public Integer getUPermit() {
        return uPermit;
    }

    public void setUPermit(Integer uPermit) {
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
