package com.aiaixyz.jiumanager.entity.vo;

/**
 * author LeeC
 * date 2023/3/9
 * since JDK 1.8
 */

/**
 * 响应对象
 */
public class RespBean {
    private int status;
    private String mas;
    private Object data;

    public static RespBean respSuccess(String msg,Object data){
        return new RespBean(200,msg,data);
    }

    public static RespBean respError(String msg,Object data){
        return new RespBean(500,msg,data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMas() {
        return mas;
    }

    public void setMas(String mas) {
        this.mas = mas;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "status=" + status +
                ", mas='" + mas + '\'' +
                ", data=" + data +
                '}';
    }

    public RespBean() {
    }

    public RespBean(int status, String mas, Object data) {
        this.status = status;
        this.mas = mas;
        this.data = data;
    }
}
