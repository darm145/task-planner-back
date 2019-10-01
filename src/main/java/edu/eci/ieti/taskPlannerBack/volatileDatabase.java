package edu.eci.ieti.taskPlannerBack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.eci.ieti.taskPlannerBack.Entities.Task;
import edu.eci.ieti.taskPlannerBack.Entities.User;

@Component
@Scope("singleton")
public class volatileDatabase implements databaseConnection {
    ArrayList<User> users=new ArrayList<User>();
    ArrayList<Task> tasks=new ArrayList<Task>();
    @Override
    public List<Task> geTasksList() {
        return tasks;
    }

    @Override
    public Task getTaskById(String id) {
        for(Task t:tasks){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        ArrayList<Task> usertasks=new ArrayList<Task>();
        for(Task t: tasks){
            if(t.getOwner().getId().equals(userId)){
                usertasks.add(t);
            }
        }
        return usertasks;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        for(Task t:tasks){
            if(t.getId().equals(taskId)){
                t.setOwner(user);
                return t;
            }
        }
        return null;
    }

    @Override
    public void removeTask(String taskId) {
        Task toBeRemoved=null;
        for(Task t:tasks){
            if(t.getId().equals(taskId)){
                toBeRemoved=t;
                break;
            }
        }
        if(!toBeRemoved.equals(null)){
            tasks.remove(toBeRemoved);
        }
    }

    @Override
    public Task updateTask(Task task) {
        Task toBeUpdated=null;
        for(Task t:tasks){
            if(t.getId().equals(task.getId())){
                toBeUpdated=t;
                break;
            }
        }
        if(!toBeUpdated.equals(null)){
            toBeUpdated=task;
        }
        return toBeUpdated;
    }

    @Override
    public List<User> getUsersList() {
        return users;
    }

    @Override
    public User getUserById(String userId) {
        for(User u:users){
            if (u.getId().equals(userId)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User toBeUpdated=null;
        for(User u:users){
            if(u.getId().equals(user.getId())){
                toBeUpdated=u;
                break;
            }
        }
        if(!toBeUpdated.equals(null)){
            toBeUpdated=user;
        }
        return toBeUpdated;
    }

    @Override
    public void removeUser(String userId) {
        User toBeRemoved=null;
        for(User u:users){
            if(u.getId().equals(userId)){
                toBeRemoved=u;
                break;
            }
        }
        if(!toBeRemoved.equals(null)){
            users.remove(toBeRemoved);
        }

    }
    
}