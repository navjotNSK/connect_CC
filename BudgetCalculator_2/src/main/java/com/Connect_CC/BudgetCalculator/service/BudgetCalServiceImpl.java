package com.Connect_CC.BudgetCalculator.service;

import com.Connect_CC.BudgetCalculator.controller.response.CalResponse;
import com.Connect_CC.BudgetCalculator.exception.CustomCalException;
import org.springframework.stereotype.Service;

@Service
public class BudgetCalServiceImpl implements BudgetCalServiceInterface{
    @Override
    public CalResponse calculate(double salary, double houseRent, double grocery, double transportation, double miscellaneous) {
        if(String.valueOf(salary).isEmpty() || String.valueOf(houseRent).isEmpty() || String.valueOf(grocery).isEmpty() || String.valueOf(transportation).isEmpty() || String.valueOf(miscellaneous).isEmpty() ) {
            throw new CustomCalException("Field cannot be empty, Please Enter all details", "NOT_NULL");
        }
        if(salary < 0 || houseRent < 0 || grocery <0 || transportation < 0 ||miscellaneous < 0){
            throw new CustomCalException("Field cannot be negative, Please Enter correct value", "NOT_NEGATIVE");
        }
        double res = salary - houseRent - grocery - transportation - miscellaneous;

//        if(res<0){
//            throw new CustomCalException("S", "NOT_NEGATIVE");
//        }
        CalResponse calResponse = CalResponse.builder().remainingAmount(res).build();
        return calResponse;
    }
}
