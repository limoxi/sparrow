package com.training.sparrow.frame.resource;


public record Response(int code, Object data, String errCode, String errMsg) {
    public static Response NewResponse(Object data) {
        return new Response(200, data, "", "");
    }

    public static Response NewErrorResponse(Exception e) {
        return new Response(500, null, "", "");
    }
}