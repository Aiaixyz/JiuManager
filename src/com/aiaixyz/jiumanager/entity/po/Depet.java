package com.aiaixyz.jiumanager.entity.po;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class Depet {
    private Integer dId;
    private String dName;
    private String dAddress;

    @Override
    public String toString() {
        return "Depet{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dAddress='" + dAddress + '\'' +
                '}';
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }

    public Depet() {
    }

    public Depet(Integer dId, String dName, String dAddress) {
        this.dId = dId;
        this.dName = dName;
        this.dAddress = dAddress;
    }
}
