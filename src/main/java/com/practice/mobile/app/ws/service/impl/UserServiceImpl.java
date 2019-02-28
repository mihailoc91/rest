/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.service.impl;

import com.practice.mobile.app.ws.exceptions.UserServiceException;
import com.practice.mobile.app.ws.io.repositories.UserRepository;
import com.practice.mobile.app.ws.io.entity.UserEntity;
import com.practice.mobile.app.ws.service.UserService;
import com.practice.mobile.app.ws.shared.Utils;
import com.practice.mobile.app.ws.shared.dto.UserDto;
import com.practice.mobile.app.ws.ui.model.response.ErrorMessages;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mihailo
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    Utils utils;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public UserDto createUser(UserDto user) {
        
        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        
        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       
        
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        UserEntity userEntity = userRepository.findByEmail(email);
        
        if(userEntity == null) throw new UsernameNotFoundException(email);
        
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserDto getUser(String email) {
        
        UserEntity userEntity = userRepository.findByEmail(email);
        
        if(userEntity == null) throw new UsernameNotFoundException(email);
        
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);
        
        return returnValue;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        
        UserEntity userEntity = userRepository.findByUserId(userId);
        if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);
        
        return returnValue;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);
        
        if (userEntity == null) {
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }

        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());

        UserEntity updatedUserDetails = userRepository.save(userEntity);
        BeanUtils.copyProperties(updatedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) {
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
        
        userRepository.delete(userEntity);
    }
    
}
