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

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvPhone() {
        return vPhone;
    }

    public void setvPhone(String vPhone) {
        this.vPhone = vPhone;
    }

    public String getvAddress() {
        return vAddress;
    }

    public void setvAddress(String vAddress) {
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
