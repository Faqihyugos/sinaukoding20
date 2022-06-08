package com.sinaukoding.perpustakaan.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class Response implements Serializable {
    Object data;
    String message;
    HttpStatus httpStatus;

    public Response(String message, HttpStatus httpStatus,Object data) {
        this.message=message;
        this.httpStatus=httpStatus;
        this.data=data;
    }
}
