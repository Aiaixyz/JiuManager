package com.aiaixyz.jiumanager.entity.po;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class Vendors {
    private Integer vId;
    private String vName;
    private String vPhone;
    private String vAddress;

    public Vendors(String vName, String vPhone, String vAddress) {
        this.vName = vName;
        this.vPhone = vPhone;
        this.vAddress = vAddress;
    }

    @Override
    public String toString() {
        return "Vendors{" +
                "vId=" + vId +
                ", vName='" + vName + '\'' +
                ", vPhone='" + vPhone + '\'' +
                ", vAddress='" + vAddress + '\'' +
                '}';
    }

    public Integer getVId() {
        return vId;
    }

    public void setVId(Integer vId) {
        this.vId = vId;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVPhone() {
        return vPhone;
    }

    public void setVPhone(String vPhone) {
        this.vPhone = vPhone;
    }

    public String getVAddress() {
        return vAddress;
    }

    public void setVAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    public Vendors() {
    }

    public Vendors(Integer vId, String vName, String vPhone, String vAddress) {
        this.vId = vId;
        this.vName = vName;
        this.vPhone = vPhone;
        this.vAddress = vAddress;
    }
}
