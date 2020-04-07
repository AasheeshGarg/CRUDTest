package com.example.CRUDExample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDExample.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserId(Long userId);

}
