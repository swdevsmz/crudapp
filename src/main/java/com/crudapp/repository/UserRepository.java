package com.crudapp;

import com.crudapp.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;


public interface UserRepository extends Repository<UserEntity, String> {

    Page<UserEntity> findAll(Pageable pageable);

}