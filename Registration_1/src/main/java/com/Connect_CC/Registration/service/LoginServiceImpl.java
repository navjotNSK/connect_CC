package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.LoginRequest;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.entity.RegEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginServiceInterface{
    @Autowired
    private RegRepo regRepo;



    @Override
    public String login(LoginRequest loginRequest) {
      RegEntity regEntityList =  regRepo.findByEmail(loginRequest.getEmailId());
        System.out.println(regEntityList);
//      if(!regEntityList.isEmpty()){

//          String emailId = regEntityList.get(0).getEmailId();
//          String password = regEntityList.get(0).getPassword();
        String emailId = regEntityList.getEmailId();
        String password = regEntityList.getPassword();

          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//          String encodedPassword = encoder.encode(regRequest.getPassword());
//          String decodedPassword = encoder.upgradeEncoding(loginRequest.getPassword());
          boolean resP = encoder.matches(loginRequest.getPassword() , password);
//          System.out.println(resP);
//        System.out.println(loginRequest.getEmailId());
//        System.out.println(emailId);
//        System.out.println(loginRequest.getEmailId().equals(emailId));
          if(loginRequest.getEmailId().equals(emailId)  && resP){
              return "logged in";
          }
//      }

        return "User not registered, Please register!";
    }
}
