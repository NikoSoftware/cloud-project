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
    IMAGE_PARAM_FAILED(415,"图片参数异常！"),
    INVALID_USERNAME_PASSWORD(415,"用户名或密码不正确！"),
    CREATE_TOKEN_ERROR(500,"凭证生成失败！"),
    AUTH_TOKEN_ERROR(415,"非法登录！"),
    USER_NAME_DUPLICATE(415,"用户名已经存在！"),
    REGISTER_ERROR(500,"注册失败！");

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
