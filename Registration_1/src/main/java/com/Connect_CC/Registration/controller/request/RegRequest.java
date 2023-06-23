package com.Connect_CC.Registration.controller.request;
import lombok.Data;

import javax.swing.text.PasswordView;

@Data
public class RegRequest {
    private String name;
    private String emailId;
    private long phoneNo;
    private String password;
}
