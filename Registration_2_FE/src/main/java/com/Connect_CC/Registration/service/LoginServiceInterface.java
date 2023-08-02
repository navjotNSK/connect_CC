package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.LoginRequest;
import com.Connect_CC.Registration.controller.request.RegRequest;

public interface LoginServiceInterface {
    String login(LoginRequest loginRequest);
}
