package com.wa.common;

public enum  ResponseCode {
    SUCCESS(1,"success"),
    ERROR(0,"error"),
    NEED_LOGIN(10,"need_login"),
    ARG_ERROR(100,"argment error");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
