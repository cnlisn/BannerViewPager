package com.lisn.idea.net.common;

/**
 * Author: LiShan
 * Time: 2019-10-29
 * Description:
 */
public class BasicResponse<T> {

    private int errorCode;
    private String errorMsg;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T results) {
        this.data = results;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setCode(int code) {
        this.errorCode = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String message) {
        this.errorMsg = message;
    }
}
