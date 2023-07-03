package com.Connect_CC.BudgetCalculator.controller.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalResponse {
    private double remainingAmount;
}
