package com.Connect_CC.BudgetCalculator.controller.request;
import lombok.Data;

@Data
public class CalRequest {
    private double salary;
    private double houseRent;
    private double grocery;
    private double transportation;
    private double miscellaneous;
}
