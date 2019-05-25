package com.hhs.studybook.util;

public enum ResultCode {

    CODE_OK(200, "Success"),
    SIGN_ERROR(404, "Error"),
    ADD_SUCCESS(233, "Add_Success"),
    NO_ELEMENT(123, "Cannot find element in database"),
    LOGIN_SUCCESS(234, "Login success"),
    LOGIN_FAIL(410, "Login fail"),
    USERNAME_EXIST(411, "Username exist"),
    PARA_ERROR(412, "Parameter error")
    ;

    private Integer code;
    private String msg;

    /**
     *
     *
     * @param code A number represents a type of information. 200 and 233 represent success; otherwise something's wrong
     * @param msg  The detailed information.
     */
    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Get the success/error code
     * @return the success/error code
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * Get the success/error message
     * @return the success/error message
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * Change the code and msg into a string
     * @return The string type of the code and the msg
     */
    @Override
    public String toString() {
        return "code:" + code + ", msg" + msg;
    }
}