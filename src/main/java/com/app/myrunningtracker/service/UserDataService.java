package com.app.myrunningtracker.service;

import com.app.myrunningtracker.entity.UserDataEntity;
import com.app.myrunningtracker.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;

    @Autowired
    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }


    public UserDataEntity addNewRecord(UserDataEntity data) {
        return userDataRepository.save(data);
    }

    public List<UserDataEntity> getRecords(int user_id) {
       return userDataRepository.findAllByUser_Id(user_id);
    }

    public void deleteRecordById(int id) {
       userDataRepository.deleteById(id);
    }

    public void updateRecord(UserDataEntity data, int user_id, int id) {
       UserDataEntity dataRecord = userDataRepository.findAllByUser_IdAndId(user_id, id);
       dataRecord.setDistance(data.getDistance());
       dataRecord.setDate(data.getDate());
       dataRecord.setTime(data.getTime());
       userDataRepository.save(dataRecord);
    }
}
