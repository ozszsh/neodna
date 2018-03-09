package com.dna.entity;

/**
 * Created by peng on 18/3/9.
 */
public class Response {
    private String response_code;
    private String error_desc;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getError_desc() {
        return error_desc;
    }

    public void setError_desc(String error_desc) {
        this.error_desc = error_desc;
    }

    public Response(){
        setResponse_code("999999");
        setError_desc("error");
    }

}
