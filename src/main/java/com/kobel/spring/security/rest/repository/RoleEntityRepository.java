package com.kobel.spring.security.rest.repository;

import com.kobel.spring.security.rest.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository <RoleEntity, Integer> {
    RoleEntity findAllByName(String name);

}
