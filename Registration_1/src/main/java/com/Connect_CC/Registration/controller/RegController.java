package com.Connect_CC.Registration.controller;

import com.Connect_CC.Registration.constant.RegAPIConstants;
import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.controller.response.RegResponse;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.service.RegServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RegAPIConstants.BASE_URL)
public class RegController {

    @Autowired
    RegServiceInterface regService;

    @Autowired
    RegRepo regRepo;

    @PostMapping(value = RegAPIConstants.CREATE_USER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser( @RequestBody RegRequest request) {
        String msg =  regService.saveUser(request);
        System.out.println(regRepo.findAll());
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/reg")
    public String reg(){
        return "Log";
    }

}
