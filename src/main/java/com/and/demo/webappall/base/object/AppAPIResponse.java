package com.and.demo.webappall.base.object;

public class AppAPIResponse {
    String status;
    String errDescription;
    Object response;

    public AppAPIResponse(String status, String errDescription , Object response ) {
        this.status = status;
        this.errDescription = errDescription;
        this.response = response;
    }

    public String getErrDescription() {
        return errDescription;
    }

    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
