package com.app.myrunningtracker.repository;

import com.app.myrunningtracker.entity.UserDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataRepository extends CrudRepository<UserDataEntity, Integer>{

    List<UserDataEntity> findAllByUser_Id(int user_id);

    UserDataEntity findAllByUser_IdAndId(int user_id, int id);
}
