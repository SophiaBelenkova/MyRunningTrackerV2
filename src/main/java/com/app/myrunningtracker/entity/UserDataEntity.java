package com.app.myrunningtracker.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class UserDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //primary key, type: integer
    private java.sql.Date date; //type: date
    private Time time; //type: time
    private float distance; //type: float

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user; //this helps us connect UserEntity to UserDataEntity

    public UserDataEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
