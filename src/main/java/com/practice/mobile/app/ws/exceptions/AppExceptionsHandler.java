/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.exceptions;

import com.practice.mobile.app.ws.ui.model.response.ErrorMessage;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Mihailo
 */

@ControllerAdvice
public class AppExceptionsHandler {
    
    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException (UserServiceException ex, WebRequest req){
        
        ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getMessage());
        
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions (Exception ex, WebRequest req){
        
        ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getMessage());
        
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
