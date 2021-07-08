package com.example.demo.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    protected Integer status;
    protected String message;

    public Response(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response success(String message) {
        return new Response(HttpStatus.OK.value(), message);
    }

    public static Response badRequest(String message) {
        return new Response(HttpStatus.BAD_REQUEST.value(), message);
    }

    public static Response notFound(String message) {
        return new Response(HttpStatus.NOT_FOUND.value(), message);
    }

    public static Response internalError(String message) {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static Response conflict(String message) {
        return new Response(HttpStatus.CONFLICT.value(), message);
    }
}

