package com.aiaixyz.jiumanager.entity.po;

import java.sql.Timestamp;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
public class Report {
    Integer rId;
    Timestamp rDate;
    String rOperation;
    String rNote;
    Integer uId;
    Integer sSku;

    public Report(Integer rId, String rOperation, String rNote, Integer uId, Integer sSku) {
        this.rId = rId;
        this.rOperation = rOperation;
        this.rNote = rNote;
        this.uId = uId;
        this.sSku = sSku;
    }

    @Override
    public String toString() {
        return "Report{" +
                "rId=" + rId +
                ", rDate=" + rDate +
                ", rOperation='" + rOperation + '\'' +
                ", rNote='" + rNote + '\'' +
                ", uId=" + uId +
                ", sSku=" + sSku +
                '}';
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public Timestamp getRDate() {
        return rDate;
    }

    public void setRDate(Timestamp rDate) {
        this.rDate = rDate;
    }

    public String getROperation() {
        return rOperation;
    }

    public void setROperation(String rOperation) {
        this.rOperation = rOperation;
    }

    public String getRNote() {
        return rNote;
    }

    public void setRNote(String rNote) {
        this.rNote = rNote;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getSSku() {
        return sSku;
    }

    public void setSSku(Integer sSku) {
        this.sSku = sSku;
    }

    public Report() {
    }

    public Report(String rOperation, String rNote, Integer uId, Integer sSku) {
        this.rOperation = rOperation;
        this.rNote = rNote;
        this.uId = uId;
        this.sSku = sSku;
    }

    public Report(Integer rId, Timestamp rDate, String rOperation, String rNote, Integer uId, Integer sSku) {
        this.rId = rId;
        this.rDate = rDate;
        this.rOperation = rOperation;
        this.rNote = rNote;
        this.uId = uId;
        this.sSku = sSku;
    }
}
