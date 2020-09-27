package com.phyrextsai.boilerplate.parameter;

public class Response {
    private String error_code;
    private String error_message;
    private Object result;

    public String getError_code() {
        return error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public Object getResult() {
        return result;
    }

    public Boolean getStatus() {
        return (error_code != null || error_message != null) ? false : true;
    }

    public void setError_code(String errorCode) {
        this.error_code = errorCode;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
