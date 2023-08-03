package com.Connect_CC.BudgetCalculator.controller;

import com.Connect_CC.BudgetCalculator.constant.BudgetCalConstants;
import com.Connect_CC.BudgetCalculator.controller.request.CalRequest;
import com.Connect_CC.BudgetCalculator.controller.response.CalResponse;
import com.Connect_CC.BudgetCalculator.service.BudgetCalServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;

@CrossOrigin
@RestController
public class FrontEndController {

    @Autowired
    private BudgetCalServiceInterface budgetCalService;
    @PostMapping(value =BudgetCalConstants.CAL_PAGE + BudgetCalConstants.BASE_URL + BudgetCalConstants.POST_BUDGET)
    public ResponseEntity<CalResponse> saveUser(@ModelAttribute CalRequest request) {
        //call service method

        double salary = request.getHourlyWage() * request.getMonthlyHoursWorked();
        double houseRent = request.getHouseRent();
        double grocery = request.getGrocery();
        double transportation = request.getTransportation();
        double miscellaneous = request.getMiscellaneous();
        CalResponse calResponse = budgetCalService.calculate(salary , houseRent , grocery , transportation , miscellaneous);
        System.out.println(houseRent + " " + salary + " " + calResponse);
        return new ResponseEntity<>(calResponse, HttpStatus.OK);
    }
    @RequestMapping( value = BudgetCalConstants.CAL_PAGE , method=RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BudgetCalculator");
        return modelAndView;
    }




}
