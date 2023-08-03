package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.controller.response.RegResponse;

public interface RegServiceInterface {
    String saveUser(RegRequest regRequest);
    RegResponse getUser(String emailId);
}
