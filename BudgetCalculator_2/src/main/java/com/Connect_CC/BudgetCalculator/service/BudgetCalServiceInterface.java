package com.Connect_CC.BudgetCalculator.service;

import com.Connect_CC.BudgetCalculator.controller.response.CalResponse;

public interface BudgetCalServiceInterface {


    CalResponse calculate(double salary , double houseRent , double grocery , double transportation , double miscellaneous);

}
