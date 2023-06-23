package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.entity.RegEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class RegServiceImpl implements RegServiceInterface{

@Autowired
private RegRepo regRepo;

    @Override
    public String saveUser(RegRequest regRequest) {
        Long regId =  regRepo.finRegId(regRequest.getEmailId());
        if(regId == null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(regRequest.getPassword());
//        boolean isPasswordMatch = encoder.matches("myPassword", encodedPassword);


            RegEntity regEntity = RegEntity.builder().name(regRequest.getName()).
                    emailId(regRequest.getEmailId()).
                    password(encodedPassword).phoneNo(regRequest.getPhoneNo()).build();
            regRepo.save(regEntity);
            return "Saved";
        }


//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(regRequest.getPassword());
//        boolean isPasswordMatch = encoder.matches("myPassword", encodedPassword);
//
//
//        RegEntity regEntity = RegEntity.builder().name(regRequest.getName()).
//                emailId(regRequest.getEmailId()).
//                password(encodedPassword).phoneNo(regRequest.getPhoneNo()).build();
//        regRepo.save(regEntity);
        return "User already exists";
    }
}
