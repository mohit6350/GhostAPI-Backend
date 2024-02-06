package com.ghostAPI.app.config;

public class StubMapping {
    private Request request;
    private Response response;

    // Getters and setters

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "StubMapping{" +
                "request=" + request +
                ", response=" + response +
                '}';
    }
}
