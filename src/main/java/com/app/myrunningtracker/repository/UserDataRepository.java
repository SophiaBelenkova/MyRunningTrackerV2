package com.app.myrunningtracker.repository;

import com.app.myrunningtracker.entity.UserDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserDataEntity, Integer>{

}
