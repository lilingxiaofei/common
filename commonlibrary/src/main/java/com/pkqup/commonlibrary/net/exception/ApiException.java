package com.pkqup.commonlibrary.net.exception;

/**
 * Created by 康颢曦 on 2017/11/7.
 */

public class ApiException extends RuntimeException {

    private int code;

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
