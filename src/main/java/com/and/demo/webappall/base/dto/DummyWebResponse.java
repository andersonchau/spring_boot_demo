package com.and.demo.webappall.base.dto;

public class DummyWebResponse {
    String message;

    public DummyWebResponse(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
