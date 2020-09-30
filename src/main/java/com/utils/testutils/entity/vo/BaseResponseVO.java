package com.utils.testutils.entity.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import static com.utils.testutils.entity.enums.BaseResponseEnums.*;

public class BaseResponseVO implements Serializable {

    private int code;
    private long serverTime;
    private String message;
    private Object data;

    public static BaseResponseVO success(Object content){
        return new BaseResponseVO(SUCCESS.getCode(),SUCCESS.getMessage(),content);
    }

    public static BaseResponseVO fail(Object content){
        return new BaseResponseVO(FAIL.getCode(),FAIL.getMessage(),content);
    }

    public static BaseResponseVO error(Object content){
        return new BaseResponseVO(ERROR.getCode(),ERROR.getMessage(),content);
    }

    public static BaseResponseVO warn(Class<?> aClass, String eMessage, String message, String s){
        return new BaseResponseVO(ERROR.getCode(),ERROR.getMessage(),aClass);
    }

    BaseResponseVO(int code, String message, Object data) {

        this.code = code;
        this.serverTime = System.currentTimeMillis();
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
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
        return "BaseResponseVO{" +
                "code=" + code +
                ", serverTime=" + serverTime +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}