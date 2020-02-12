package com.revature.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
@RequestMapping("/test-controller")
public class TestController {

    @GetMapping(value ="/test",produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String test(){

        return " hello, java class configured string mvc";

    }
}
