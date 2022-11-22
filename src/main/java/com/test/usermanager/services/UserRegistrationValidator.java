package com.test.usermanager.services;

import com.test.usermanager.entities.User;
import  static  com.test.usermanager.services.UserRegistrationValidator.*;
import java.time.Period;
import java.util.function.Function;
import java.time.LocalDate;

public interface UserRegistrationValidator extends Function<User, ValidationResult> {

    String  FRENCH = "french";

    // just adulte users (age > 18) can be accepted
    static  UserRegistrationValidator isAnAdult(){
      return user -> Period.between(user.getBirthDate() , LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_ADULT ;
  }
    // just french French residents will be accepted
    static  UserRegistrationValidator isFrench(){
        return user -> user.getCountry().equals(FRENCH) ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_FRENCH_RESIDENT;
    }

    // just user with valid Name  will be accepted
    static UserRegistrationValidator isValidName(){
        return user -> !user.getName().equals("") ? ValidationResult.SUCCESS: ValidationResult.IS_NOT_VALID_NAME ;
    }

    default UserRegistrationValidator and (UserRegistrationValidator other){
       return user -> {
           ValidationResult result = this.apply(user);
           return result.equals(ValidationResult.SUCCESS) ? other.apply(user): result;
       };
    }
    enum ValidationResult {
        SUCCESS,
        IS_NOT_FRENCH_RESIDENT,
        IS_NOT_VALID_NAME,
        IS_NOT_ADULT,
    }

}
