package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.LoginRequest;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.entity.RegEntity;
import com.Connect_CC.Registration.exception.CustomRegException;
import com.Connect_CC.Registration.exception.UserNotFoundException;
import com.Connect_CC.Registration.validator.ValidatorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class LoginServiceImpl implements LoginServiceInterface{
    @Autowired
    private RegRepo regRepo;
    @Autowired
    private ValidatorInterface validator;


    @Override
    public String login(LoginRequest loginRequest) {
        String emailIdl = loginRequest.getEmailId();
        String passwordl =loginRequest.getPassword();

        if(emailIdl.isEmpty() || passwordl.isEmpty() ) {
            throw new CustomRegException("Field cannot be empty, Please Enter all details", "NOT_NULL");
        }
        if(!validator.validateEmail(emailIdl)) {
            throw new CustomRegException("Please check your emailId." , "INVALID_EMAIL");
            //Validation user Password - It contains at least 8 characters and at most 20 characters at least one digit , at least one upper case alphabet , at least one lower case alphabet , at least one special character which includes !@#$%&*()-+=^. , doesn’t contain any white space.
        }
        List<RegEntity> regEntityList =  regRepo.findByEmail(loginRequest.getEmailId());

        final String[] emailId = {""};
        final String[] password = {""};
        regEntityList.stream().forEach(x->{ emailId[0] = x.getEmailId(); password[0] = x.getPassword();});

        System.out.println(regEntityList);

      if(regEntityList.isEmpty()) {
throw new UserNotFoundException("User not found","NOT_FOUND");
      }
//          String emailId = regEntityList.get(0).getEmailId();
//          String password = regEntityList.get(0).getPassword();
//        String emailId = regEntityList.getEmailId();
//        String password = regEntityList.getPassword();

          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//          String encodedPassword = encoder.encode(regRequest.getPassword());
//          String decodedPassword = encoder.upgradeEncoding(loginRequest.getPassword());
          boolean resP = encoder.matches(loginRequest.getPassword() , password[0]);
//          System.out.println(resP);
//        System.out.println(loginRequest.getEmailId());
//        System.out.println(emailId);
//        System.out.println(loginRequest.getEmailId().equals(emailId));
          if(loginRequest.getEmailId().equals(emailId[0])  && resP){
              return "Logged in Successfully.";
          }
//      }

        return "Email Id or Password is not correct, Please Check!";
    }
}
