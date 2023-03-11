package com.aiaixyz.jiumanager.entity.po;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class Sku {
    private Integer sSku;
    private String sName;
    private Integer sQuantity;
    private Integer dId;
    private Integer vId;

    @Override
    public String toString() {
        return "Sku{" +
                "sSku=" + sSku +
                ", sName='" + sName + '\'' +
                ", sQuantity=" + sQuantity +
                ", dId=" + dId +
                ", vId=" + vId +
                '}';
    }

    public Integer getsSku() {
        return sSku;
    }

    public void setsSku(Integer sSku) {
        this.sSku = sSku;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsQuantity() {
        return sQuantity;
    }

    public void setsQuantity(Integer sQuantity) {
        this.sQuantity = sQuantity;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Sku() {
    }

    public Sku(Integer sSku, String sName, Integer sQuantity, Integer dId, Integer vId) {
        this.sSku = sSku;
        this.sName = sName;
        this.sQuantity = sQuantity;
        this.dId = dId;
        this.vId = vId;
    }
}