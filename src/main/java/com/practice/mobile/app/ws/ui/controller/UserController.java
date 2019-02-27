/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.ui.controller;

import com.practice.mobile.app.ws.service.UserService;
import com.practice.mobile.app.ws.shared.dto.UserDto;
import com.practice.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.practice.mobile.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mihailo
 */

@RestController
@RequestMapping("users")
public class UserController {
    
    @Autowired
    UserService userService;
    
    
    
    @GetMapping
    public String getUser(){
        return "getUser was called";
    }
    
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        
        UserRest returnValue = new UserRest();
        
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);
        
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        
        return returnValue;
    }
    
    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }
    
    @DeleteMapping
    public String deleteUser(){
        return "deleteUser was called";
    }
}
