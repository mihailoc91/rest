/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.service;

import com.practice.mobile.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Mihailo
 */
public interface UserService extends UserDetailsService{
    
    UserDto createUser (UserDto user);
    UserDto getUser (String email);
}
