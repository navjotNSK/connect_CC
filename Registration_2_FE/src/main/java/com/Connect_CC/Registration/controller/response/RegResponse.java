package com.Connect_CC.Registration.controller.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegResponse {
    private long regId;
    private String name;
    private String emailId;
    private long phoneNo;
    private String password;


}
