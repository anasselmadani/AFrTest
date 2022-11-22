package com.test.usermanager.controller;

import com.test.usermanager.entities.User;
import com.test.usermanager.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
@Api(value="User Rest Endpoint")
public class UserController {

    @Autowired
    private UserService userSvc;

    @ApiOperation(value = "Return specific user by Id")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userSvc.findUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Return the created user")
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userSvc.addUsr(user);
        System.out.print(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
