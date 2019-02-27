/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mihailo
 */
@Component
public class AppProperties {
    
    @Autowired
    private Environment env;
    
    public String getTokenSecret(){
        return env.getProperty("tokenSecret");
    }
}
