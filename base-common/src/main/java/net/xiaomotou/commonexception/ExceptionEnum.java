package net.xiaomotou.commonexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @Feature:
 */

public enum ExceptionEnum {

    //图片插入失败
    IMAGE_STORAGE_FAILED(500,"图片储存异常！"),
    IMAGE_PARAM_FAILED(415,"图片参数异常！");


    private int code;
    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
