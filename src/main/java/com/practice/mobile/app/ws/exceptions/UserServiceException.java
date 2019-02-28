/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.exceptions;

/**
 *
 * @author Mihailo
 */
public class UserServiceException extends RuntimeException{

    private static final long serialVersionUID = 1348771109171435607L;
    
    public UserServiceException(String message) {
        super(message);
    }
    
    
}
