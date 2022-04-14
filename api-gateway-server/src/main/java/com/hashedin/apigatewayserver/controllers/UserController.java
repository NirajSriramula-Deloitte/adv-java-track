package com.hashedin.apigatewayserver.controllers;

import com.hashedin.apigatewayserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hashedin.apigatewayserver.entities.User;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    //SginIN API
    @GetMapping("/user/signIn")
    public ResponseEntity<Object> signIn(@RequestParam(name = "mobile",required = false,defaultValue = "") String mobile, @RequestParam(name = "dobs",required = false,defaultValue = "") String dobs) {
        return null;

    }


    //SignUP API
    @PostMapping("user/SignUp")
    public ResponseEntity<Object> postUser(@RequestBody User userBody) {
       return null;
    }
}
