package com.test.usermanager.services;
import com.test.usermanager.entities.User;
import  static  com.test.usermanager.services.UserRegistrationValidator.*;


public interface UserService {

    /**
     * get user from his id .
     * @param  userId  user id
     * @return  user
     */
    User findUser(Long userId);

    /**
     * add user from .
     * @param  user
     * @return  user added
     */
    User addUsr(User user);

    /**
     * check if user valid to register.
     * @param  user
     * @return  SUCCESS if user valid else the reason why user is not valid
     */
    ValidationResult isValidToRegister(User user);
}
