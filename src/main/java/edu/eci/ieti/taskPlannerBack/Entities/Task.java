package edu.eci.ieti.taskPlannerBack.Entities;

import java.util.Date;

public class Task {
    private String activity;
    private String state;
    private Date date;
    private User owner;
    public Task(){
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
}