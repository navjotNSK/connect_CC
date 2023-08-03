package com.Connect_CC.Registration.validator;

import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl implements ValidatorInterface{

    @Override
    public boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

        if(password.matches(regex)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean validateEmail(String email) {
        String regex = "^[a-z0-9+_.-]+@(.+)(\\.com)$";
//		String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        if(email.matches(regex)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean validatePhoneNo(Long phoneNo) {
        String regex = "^\\d{10}$";

        if(phoneNo.toString().matches(regex)) {
            return true;
        }
        return false;
    }
}
