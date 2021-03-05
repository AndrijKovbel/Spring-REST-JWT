package com.kobel.spring.security.rest.service;

import com.kobel.spring.security.rest.entity.RoleEntity;
import com.kobel.spring.security.rest.entity.UserEntity;
import com.kobel.spring.security.rest.repository.RoleEntityRepository;
import com.kobel.spring.security.rest.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    RoleEntityRepository roleEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity saveUser(UserEntity userEntity) {
        RoleEntity userRole = roleEntityRepository.findAllByName("ROLE_USER");
        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntityRepository.save(userEntity);
        return userEntityRepository.save(userEntity);
    }


    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }


    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

}
