package com.test.usermanager.services;

import com.test.usermanager.entities.User;
import com.test.usermanager.exceptions.UserException;
import com.test.usermanager.exceptions.UserNotFoundException;
import com.test.usermanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<User>  findUser(Long userId) {
        User user =userRepository.findUserById(userId).orElseThrow(()-> new UserException(HttpStatus.NOT_FOUND,"User note found"));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> addUsr(User user) {
        UserRegistrationValidator.ValidationResult result = isValidToRegister(user);
        if (result != UserRegistrationValidator.ValidationResult.SUCCESS){
            throw new UserException(HttpStatus.BAD_REQUEST,result.name());
        }
        User newUser   =   userRepository.save(user);
       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Override
    public UserRegistrationValidator.ValidationResult isValidToRegister(User user) {
         UserRegistrationValidator.ValidationResult result = UserRegistrationValidator.isAnAdult()
                .and(UserRegistrationValidator.isFrench())
                .and(UserRegistrationValidator.isValidName())
                .apply(user);
         return result;
    }
}
