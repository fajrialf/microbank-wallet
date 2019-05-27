package com.enigma.walletkurs.helper.response;

/* @rifqiabrory */
public class CommonResponse<T> {

    private int status;
    private String message;
    private T data;

    // default common response without data
    public CommonResponse() {
        this.status = 20;
        this.message = "Ok";
    }

    // success response with  data
    public CommonResponse(T data) {
        this.status = 20;
        this.message = "Ok";
        this.data = data;
    }

    // custom status and message
    public CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // custom status, message and data
    public CommonResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
