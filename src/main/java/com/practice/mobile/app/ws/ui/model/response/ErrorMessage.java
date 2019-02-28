/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.ui.model.response;

import java.util.Date;

/**
 *
 * @author Mihailo
 */
public class ErrorMessage {
    
    private Date timestamp;
    private String message;
    
    
    public ErrorMessage(){}
    
    public ErrorMessage(Date timestamp, String message){
        this.timestamp = timestamp;
        this.message = message;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
