package com.kobel.spring.security.rest.config.jwt;

import com.kobel.spring.security.rest.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomeUserDetails implements UserDetails {

    private String login;
    private String  password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomeUserDetails fromUserEntityToCustomUserDetails(UserEntity userEntity){
        CustomeUserDetails customeUserDetails = new CustomeUserDetails();
        customeUserDetails.login = userEntity.getLogin();
        customeUserDetails.password = userEntity.getPassword();
        customeUserDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRoleEntity().getName()));
        return customeUserDetails;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
