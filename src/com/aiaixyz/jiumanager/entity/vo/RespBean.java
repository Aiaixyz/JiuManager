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
    private String msg;
    private Object data;

    public static RespBean respSuccess(String msg,Object data){
        return new RespBean(200,msg,data);
    }

    public static RespBean respError(String msg,Object data){
        return new RespBean(500,msg,data);
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RespBean(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
