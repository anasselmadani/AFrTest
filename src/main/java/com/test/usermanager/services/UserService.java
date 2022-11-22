package com.test.usermanager.services;
import com.test.usermanager.entities.User;
import org.springframework.http.ResponseEntity;

import  static  com.test.usermanager.services.UserRegistrationValidator.*;


public interface UserService {

    /**
     * get user from his id .
     * @param  userId  user id
     * @return  user
     */
    ResponseEntity<User> findUser(Long userId);

    /**
     * add user from .
     * @param  user
     * @return  user added
     */
    ResponseEntity<User>  addUsr(User user);

    /**
     * check if user valid to register.
     * @param  user
     * @return  SUCCESS if user valid else the reason why user is not valid
     */
    ValidationResult isValidToRegister(User user);
}
