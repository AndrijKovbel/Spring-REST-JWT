package com.kobel.spring.security.rest.service;


import com.kobel.spring.security.rest.config.jwt.CustomeUserDetails;
import com.kobel.spring.security.rest.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CustomeUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByLogin(username);
        return CustomeUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
