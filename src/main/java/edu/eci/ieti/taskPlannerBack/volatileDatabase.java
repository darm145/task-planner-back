package edu.eci.ieti.taskPlannerBack;

import java.util.ArrayList;
import java.util.List;

import edu.eci.ieti.taskPlannerBack.Entities.Task;
import edu.eci.ieti.taskPlannerBack.Entities.User;

public class volatileDatabase implements databaseConnection {
    ArrayList<User> users=new ArrayList<User>();
    ArrayList<Task> tasks=new ArrayList<Task>();
    @Override
    public List<Task> geTasksList() {
        return null;
    }

    @Override
    public Task getTaskById(String id) {
        return null;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return null;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        return null;
    }

    @Override
    public void removeTask(String taskId) {

    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void removeUser(String userId) {

    }
    
}