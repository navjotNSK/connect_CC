package com.Connect_CC.BudgetCalculator.controller.request;
import lombok.Data;

@Data
public class CalRequest {
    private double hourlyWage;
    private double monthlyHoursWorked;
    private double houseRent;
    private double grocery;
    private double transportation;
    private double miscellaneous;
}
