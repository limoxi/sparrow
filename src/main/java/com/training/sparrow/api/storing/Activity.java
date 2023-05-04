package com.training.sparrow.api.storing;

import com.training.sparrow.frame.annotation.*;
import com.training.sparrow.frame.resource.Response;

import java.util.Date;
import java.util.Map;

@Resource("storing.activity")
public class Activity {

    @Get
    public Response Get() {
        return Response.NewResponse(Map.ofEntries(
                Map.entry("time", new Date().toString()),
                Map.entry("method", "GET")
        ));
    }

    @Put
    public Response Put() throws Exception {
        throw new Exception("hehehda");
//        return new Response(Map.ofEntries(
//                Map.entry("time", new Date().toString()),
//                Map.entry("method", "PUT")
//        ));
    }

    @Post
    public Response Post() {
        return Response.NewResponse(Map.ofEntries(
                Map.entry("time", new Date().toString()),
                Map.entry("method", "POST")
        ));
    }

    @Delete
    public Response Delete() {
        return Response.NewResponse(Map.ofEntries(
                Map.entry("time", new Date().toString()),
                Map.entry("method", "DELETE")
        ));
    }

}
