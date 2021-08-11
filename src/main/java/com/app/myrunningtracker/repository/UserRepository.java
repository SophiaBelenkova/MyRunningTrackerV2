package com.app.myrunningtracker.repository;

import com.app.myrunningtracker.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndPassword(String username, String password);
}
