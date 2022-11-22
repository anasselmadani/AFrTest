package com.test.usermanager.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UserException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public UserException(String message) {
        super();
        this.message = message;
    }

    public UserException(HttpStatus httpStatus,String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
