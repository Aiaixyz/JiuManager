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

    public Sku(String sName, Integer sQuantity, Integer dId, Integer vId) {
        this.sName = sName;
        this.sQuantity = sQuantity;
        this.dId = dId;
        this.vId = vId;
    }

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

    public Integer getSSku() {
        return sSku;
    }

    public void setSSku(Integer sSku) {
        this.sSku = sSku;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public Integer getSQuantity() {
        return sQuantity;
    }

    public void setSQuantity(Integer sQuantity) {
        this.sQuantity = sQuantity;
    }

    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public Integer getVId() {
        return vId;
    }

    public void setVId(Integer vId) {
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