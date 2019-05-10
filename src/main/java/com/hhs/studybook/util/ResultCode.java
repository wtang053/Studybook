package com.hhs.studybook.util;

public enum ResultCode {

    CODE_OK(200, "Success"),
    SIGN_ERROR(404, "Error"),
    ADD_SUCCESS(233, "Add_Success"),
    NO_ELEMENT(123, "Cannot find element in database");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg" + msg;
    }
}