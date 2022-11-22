package com.test.usermanager.services;

import com.test.usermanager.entities.User;
import com.test.usermanager.exceptions.UserNotFoundException;
import com.test.usermanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUser(Long userId) {
      return userRepository.findUserById(userId).orElseThrow(()-> new UserNotFoundException(userId));
    }

    @Override
    public User addUsr(User user) {
        UserRegistrationValidator.ValidationResult result = isValidToRegister(user);
        if (result != UserRegistrationValidator.ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
        return userRepository.save(user);
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
