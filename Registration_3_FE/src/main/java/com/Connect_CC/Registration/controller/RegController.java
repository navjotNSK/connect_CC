package com.Connect_CC.Registration.controller;

import com.Connect_CC.Registration.constant.RegAPIConstants;
import com.Connect_CC.Registration.controller.request.RegRequest;
import com.Connect_CC.Registration.controller.response.RegResponse;
import com.Connect_CC.Registration.dao.RegRepo;
import com.Connect_CC.Registration.service.RegServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;

@CrossOrigin
@RestController
@RequestMapping(value = RegAPIConstants.BASE_URL)
public class RegController {

    @Autowired
    RegServiceInterface regService;

    @Autowired
    RegRepo regRepo;


@Operation(summary = "")
@ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No Content")})
    @PostMapping(value = RegAPIConstants.CREATE_USER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser( @ModelAttribute RegRequest request ,@RequestBody RegRequest request1) {
      System.out.println( request1.toString());
        String msg =  regService.saveUser(request1);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


    @GetMapping(value = RegAPIConstants.GET_USER, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegResponse> getUser(@PathVariable("emailId") String emailId) {
        RegResponse regResponse =  regService.getUser(emailId);
        return new ResponseEntity<>(regResponse, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = RegAPIConstants.TEST_USER ,produces = MediaType.TEXT_PLAIN_VALUE )
    public ResponseEntity<String> reg( final HttpServletResponse response){
        ResponseCookie cookie = ResponseCookie.from("myCookie", "myCookieValue") // key & value
                .httpOnly(false)
                .secure(true)
                //    .domain("localhost")  // host
                //    .path("/")      // path
                .maxAge(Duration.ofHours(1))
                .sameSite("None")  // sameSite
                .path("v1/cc-reg-api/reg/reg/")
                .domain("localhost")
                .build()
                ;
        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorisation");
        response.setHeader("Access-Control-Allow-Credentials","true");
        return new ResponseEntity<>("Hello World again", HttpStatus.OK);

    }

}
