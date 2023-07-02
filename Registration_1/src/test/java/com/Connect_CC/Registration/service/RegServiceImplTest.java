package com.Connect_CC.Registration.service;

import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.controller.response.RegResponse;
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

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
 class RegServiceImplTest {
    @Mock
private RegRepo regRepo;

    @InjectMocks
    private RegServiceImpl regService;

    @Test
     void saveUser() {
        RegRequest regRequest = new RegRequest();
        regRequest.setEmailId("test");
        regRequest.setPassword("test");
        regRequest.setName("test");
        regRequest.setPhoneNo(1l);
        //1st Test Case
        Long regId = null;
        Mockito.lenient().when(regRepo.findRegId(regRequest.getEmailId())).thenReturn(regId);
            RegEntity regEntity = RegEntity.builder().name(regRequest.getName()).
                    emailId(regRequest.getEmailId()).
                    password(regRequest.getPassword()).phoneNo(regRequest.getPhoneNo()).build();
        RegEntity regEntity1 = new RegEntity();
        Mockito.lenient().when(regRepo.save(regEntity)).thenReturn(regEntity1);
        Assertions.assertNotNull(regService.saveUser(regRequest));

        //2nd Test Case
        Long regId1 = 1l;
        Mockito.lenient().when(regRepo.findRegId(regRequest.getEmailId())).thenReturn(regId1);
        Assertions.assertNotNull(regService.saveUser(regRequest));

        }


    @Test
    void getUser() {
        String emailId = "test";
        Long regId =  1l;
        Mockito.lenient().when(regRepo.findRegId(emailId)).thenReturn(regId);
       Optional<RegEntity> regEntity = Optional.of(new RegEntity());
        Mockito.lenient().when(regRepo.findById(regId)).thenReturn(regEntity);

//       RegResponse regResponse = RegResponse.builder().regId(regId).phoneNo(regEntity.get().getPhoneNo()).
//               emailId(regEntity.get().getEmailId()).
//               name(regEntity.get().getName()).
//               password("Password cannot be shown.").build();
       Assertions.assertNotNull(regService.getUser(emailId));
    }
}
