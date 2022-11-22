package com.test.usermanager.exceptions;

public class UserNotFoundException extends  RuntimeException{

    public  UserNotFoundException(Long userId ){
        super("User with id :"+userId+" not exist");
    };
}
