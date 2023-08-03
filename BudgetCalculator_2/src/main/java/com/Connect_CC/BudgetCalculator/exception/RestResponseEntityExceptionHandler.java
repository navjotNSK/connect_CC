package com.Connect_CC.BudgetCalculator.exception;

import com.Connect_CC.BudgetCalculator.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Imp - This class allows us to send exception directly to postman as response otherwise exception will only be thrown in ide.
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(UserNotFoundException.class)
////    @ResponseBody
////    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<ErrorResponse> handleProductServiceException(UserNotFoundException exception) {
//        return new ResponseEntity<>(new ErrorResponse().builder()
//                .errorMessage(exception.getMessage())
//                .errorCode(exception.getErrorCode())
//                .build(), HttpStatus.NOT_FOUND);
//    }


    @ExceptionHandler(CustomCalException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(CustomCalException exception) {
        return new ResponseEntity<>(new ErrorResponse().builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);
    }
}
