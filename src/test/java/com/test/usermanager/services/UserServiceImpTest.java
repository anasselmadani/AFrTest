package com.test.usermanager.services;

import com.test.usermanager.entities.User;
import javafx.util.converter.LocalDateStringConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImpTest {

    private UserService userSvc ;
    @BeforeEach
    void setUp(){
        userSvc = new UserServiceImp();
    }

    @Test
    void isNotValidNameToRegister() {
        User user = new User();
        user.setName("");
        user.setBirthDate(LocalDate.of(1997, Month.JANUARY, 1));
        user.setCountry("french");
        UserRegistrationValidator.ValidationResult result = userSvc.isValidToRegister(user);
        assertEquals(UserRegistrationValidator.ValidationResult.IS_NOT_VALID_NAME.toString(),result.toString() );
    }
    @Test
    void isNoFromValidResidentCountryToRegister() {
        User user = new User();
        user.setName("aa");
        user.setBirthDate(LocalDate.of(1997, Month.JANUARY, 1));
        user.setCountry("espagne");
        UserRegistrationValidator.ValidationResult result = userSvc.isValidToRegister(user);
        assertEquals(UserRegistrationValidator.ValidationResult.IS_NOT_FRENCH_RESIDENT.toString(),result.toString() );
    }

    @Test
    void isNotAdultToRegister() {
        User user = new User();
        user.setName("aa");
        user.setBirthDate(LocalDate.of(2020, Month.JANUARY, 1));
        user.setCountry("french");
        UserRegistrationValidator.ValidationResult result = userSvc.isValidToRegister(user);
        assertEquals(UserRegistrationValidator.ValidationResult.IS_NOT_ADULT.toString(),result.toString());
    }

    @Test
    void isValidToRegister() {
        User user = new User();
        user.setName("aa");
        user.setBirthDate(LocalDate.of(1997, Month.JANUARY, 1));
        user.setCountry("french");
        UserRegistrationValidator.ValidationResult result = userSvc.isValidToRegister(user);
        assertEquals(UserRegistrationValidator.ValidationResult.SUCCESS.toString(),result.toString() );
    }

}