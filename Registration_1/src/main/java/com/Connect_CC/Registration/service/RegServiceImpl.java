package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.controller.response.RegResponse;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.entity.RegEntity;
import com.Connect_CC.Registration.exception.CustomRegException;
import com.Connect_CC.Registration.exception.UserNotFoundException;
import com.Connect_CC.Registration.validator.ValidatorInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;


@Service
public class RegServiceImpl implements RegServiceInterface{

    @Autowired
    private ValidatorInterface validator;
@Autowired
private RegRepo regRepo;

    @Override
    public String saveUser(RegRequest regRequest) {
        long phoneNo = regRequest.getPhoneNo();
        String emailId = regRequest.getEmailId();
        String name = regRequest.getName();
        String password =regRequest.getPassword();


        if(name.isEmpty() || emailId.isEmpty() || password.isEmpty() || phoneNo == 0 ) {
            throw new CustomRegException("Field cannot be empty, Please Enter all details", "NOT_NULL");
        }

        //Phone no should by 10 digits.
        if(!validator.validatePhoneNo(phoneNo)) {
throw new CustomRegException("Please check your phone no." , "INVALID_PHONE_NO");
        }else if(!validator.validateEmail(emailId)) {
            throw new CustomRegException("Please check your emailId." , "INVALID_EMAIL");
            //Validation user Password - It contains at least 8 characters and at most 20 characters at least one digit , at least one upper case alphabet , at least one lower case alphabet , at least one special character which includes !@#$%&*()-+=^. , doesn’t contain any white space.
        }else if(!validator.validatePassword(password)) {
            throw new CustomRegException("Please check your password." , "INVALID_PASSWORD");

        }else {
            Long regId = regRepo.findRegId(emailId);
            if (regId == null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String encodedPassword = encoder.encode(password);
//        boolean isPasswordMatch = encoder.matches("myPassword", encodedPassword);


                RegEntity regEntity = RegEntity.builder().name(name).
                        emailId(emailId).
                        password(encodedPassword).phoneNo(phoneNo).build();
                regRepo.save(regEntity);
                return "Saved";
            }

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

    @Override
    public RegResponse getUser(String emailId) {
        if( emailId.isBlank()) {
            throw new CustomRegException("Field cannot be empty, Please Enter all details", "NOT_NULL");
        }

        if(!validator.validateEmail(emailId)) {
            throw new CustomRegException("Please check your emailId.", "INVALID_EMAIL");
        }

        Long regId =  regRepo.findRegId(emailId);
        if(regId == null){
            throw new UserNotFoundException("User with this email id does not exits","NOT_EXIST");
        }
//        RegEntity regEntity = Optional.of(regRepo.findById(regId);
       Optional<RegEntity> regEntity = regRepo.findById(regId);
        RegResponse regResponse = new RegResponse();
        System.out.println(regEntity);
//       RegResponse regResponse = RegResponse.builder().regId(regId).phoneNo(regEntity.get().getPhoneNo()).
//               emailId(regEntity.get().getEmailId()).
//               name(regEntity.get().getName()).
//               password("Password cannot be shown.").build();
        BeanUtils.copyProperties(regEntity.get(), regResponse);

        return regResponse;
    }
}
