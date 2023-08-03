package com.Connect_CC.Registration.validator;

import org.springframework.stereotype.Component;

@Component
public interface ValidatorInterface {
    public boolean validatePassword(String password) ;

    public boolean validateEmail(String email) ;

    public boolean validatePhoneNo(Long phoneNo) ;
}
