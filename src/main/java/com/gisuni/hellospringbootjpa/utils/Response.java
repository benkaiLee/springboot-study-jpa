package com.gisuni.hellospringbootjpa.utils;

import lombok.Data;

@Data
public class Response {

    /**
     * 接口响应代码
     */
    private int code; // 200, 400, 500

    /**
     * 接口访问信息
     */
    private String message;

    private Object data;

    public static Response success(Object successData ,String message){
        Response response = new Response();
        response.code = 200;
        response.message = message;
        response.data = successData;
        return response;
    }

    public static Response success(Object successData){
        Response response = new Response();
        response.code = 200;
        response.message = "Success";
        response.data = successData;
        return response;
    }

    public static Response success(){
        Response response = new Response();
        response.code = 200;
        response.message = "Success";
        return response;
    }
}