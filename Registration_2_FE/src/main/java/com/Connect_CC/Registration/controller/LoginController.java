package com.Connect_CC.Registration.controller;

import com.Connect_CC.Registration.constant.RegAPIConstants;
import com.Connect_CC.Registration.controller.request.LoginRequest;
import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.service.LoginServiceInterface;
import com.Connect_CC.Registration.service.RegServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RegAPIConstants.AUTH_URL)
public class LoginController {

@Autowired
private LoginServiceInterface loginService;
    @PostMapping(value = RegAPIConstants.CREATE_USER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String msg =  loginService.login(request);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }



}
