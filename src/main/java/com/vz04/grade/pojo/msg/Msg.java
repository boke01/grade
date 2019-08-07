package com.vz04.grade.pojo.msg;


import sun.plugin2.message.Serializer;

import java.util.HashMap;
import java.util.Map;

/**
 * 将Controller的返回数据进行最后包装
 *
 * @author vz04
 * @date 7/27/2019 1:20 PM
 **/
public class Msg {
    private int code ;
    private String message ;
    private Object data = new Object();

    /**
     * 对返回信息进行包装
     *
     * @date 1:49 PM 7/27/2019
     * @param code 状态值
     * @param message 说明
     * @param data 数据
     * @return Msg 包装后的msg
     **/
    public Msg setMsg(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
