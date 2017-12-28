package com.crudapp.repository;

import com.crudapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.List;


public interface UserRepository extends Repository<User, String> {

    Page<User> findAll(Pageable pageable);

    List<User> findById(Integer id);

}