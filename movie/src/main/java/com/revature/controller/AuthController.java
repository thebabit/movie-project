package com.revature.controller;


import com.revature.dtos.Credentials;
import com.revature.dtos.ErrorResponce;
import com.revature.exceptions.AuthenticationException;
import com.revature.models.AppUser;
import com.revature.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser login(@RequestBody Credentials creds){
        return userService.authenticate(creds);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponce handleAuthertication(AuthenticationException e){
        ErrorResponce err = new ErrorResponce();
        return err;

    }
}
