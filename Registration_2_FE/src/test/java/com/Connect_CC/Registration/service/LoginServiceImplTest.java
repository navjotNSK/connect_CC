package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.LoginRequest;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.entity.RegEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class LoginServiceImplTest {


    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Mock
    private RegRepo regRepo;

    @InjectMocks
    private  LoginServiceImpl loginService;


    @Test
    public void login() {
        String encodedPassword = "$2a$10$EUUt/9rKysLekn5pxW1Bn.mIKIOYQVf6lMtA3k2MNI29FmGYEdiAu";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmailId("test");
        loginRequest.setPassword("test");
        RegEntity regEntity = new RegEntity();
        regEntity.setPassword(encodedPassword);
        regEntity.setEmailId("test");
        Mockito.lenient().when(regRepo.findByEmail(loginRequest.getEmailId())).thenReturn(regEntity);
        Assertions.assertEquals("logged in",loginService.login(loginRequest));
         regEntity.setPassword("");
        regEntity.setEmailId("test");
        Assertions.assertEquals("User not registered, Please register!",loginService.login(loginRequest));
        Assertions.assertNotNull(regEntity);


    }
}
