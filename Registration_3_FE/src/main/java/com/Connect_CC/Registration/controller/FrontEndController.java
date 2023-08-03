package com.Connect_CC.Registration.controller;

import com.Connect_CC.Registration.constant.RegAPIConstants;
import com.Connect_CC.Registration.controller.request.LoginRequest;
import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.entity.RegEntity;
import com.Connect_CC.Registration.service.LoginServiceInterface;
import com.Connect_CC.Registration.service.RegServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
//@RequestMapping(value = RegAPIConstants.BASE_URL)
public class FrontEndController {
    @Autowired
    RegServiceInterface regService;

    @Autowired
    private LoginServiceInterface loginService;

    @Autowired
    RegRepo regRepo;

    @RequestMapping( value = RegAPIConstants.INDEX_PAGE , method=RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping( value = RegAPIConstants.REG_PAGE , method=RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView regPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;

    }

    @RequestMapping( value = RegAPIConstants.LOG_PAGE , method=RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView logPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }
    @PostMapping(value = RegAPIConstants.REG_PAGE + RegAPIConstants.CREATE_USER_PAGE)
    public ResponseEntity<String> saveUser(@ModelAttribute RegRequest request) {
        System.out.println( request.toString());
        String msg =  regService.saveUser(request);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping(value = RegAPIConstants.LOG_PAGE + RegAPIConstants.LOGIN)
    public ResponseEntity<String> login(@ModelAttribute LoginRequest request) {
        System.out.println( request.toString());
        String msg =  loginService.login(request);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
