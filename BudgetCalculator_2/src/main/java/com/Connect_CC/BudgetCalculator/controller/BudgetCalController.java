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


@RestController
@RequestMapping(value = BudgetCalConstants.BASE_URL)
public class BudgetCalController {

    @Autowired
    private BudgetCalServiceInterface budgetCalService;
    @PostMapping(value = BudgetCalConstants.POST_BUDGET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalResponse> saveUser(@RequestBody CalRequest request) {
        //call service method
         double salary = request.getHourlyWage() * request.getMonthlyHoursWorked();
         double houseRent = request.getHouseRent();
         double grocery = request.getGrocery();
         double transportation = request.getTransportation();
         double miscellaneous = request.getMiscellaneous();
        CalResponse calResponse = budgetCalService.calculate(salary , houseRent , grocery , transportation , miscellaneous);
        return new ResponseEntity<>(calResponse, HttpStatus.OK);
    }

//
//    @GetMapping(value = RegAPIConstants.GET_USER, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<RegResponse> getUser(@PathVariable("emailId") String emailId) {
//        RegResponse regResponse =  regService.getUser(emailId);
//        return new ResponseEntity<>(regResponse, HttpStatus.OK);
//    }

    @GetMapping("/reg")
    public String reg(){
        return "Log";
    }

}
