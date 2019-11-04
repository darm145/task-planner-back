package edu.eci.ieti.taskPlannerBack.Entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document

public class Task {
    @Id
    private String id;
    private String activity;
    private String state;
    private Date date;
    private User owner;
    private String imageId;
    public Task(){
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getActivity(){
        return activity;
    }
    public void setActivity(String activity){
        this.activity=activity;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state=state;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date=date;
    }

    public User getOwner(){
        return owner;
    }
    public void setOwner(User owner){
        this.owner=owner;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}