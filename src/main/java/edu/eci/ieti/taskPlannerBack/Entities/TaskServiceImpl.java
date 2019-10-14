package edu.eci.ieti.taskPlannerBack.Entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.ieti.taskPlannerBack.databaseConnection;

@Component
public class TaskServiceImpl implements TaskService {
    @Autowired
    databaseConnection database;

    @Override
    public List<Task> geTasksList() {
        return database.geTasksList();
    }

    @Override
    public Task getTaskById(String id) {
        return database.getTaskById(id);
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return database.getTasksByUserId(userId);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        return database.assignTaskToUser(taskId, user);
    }

    @Override
    public void removeTask(String taskId) {
        database.removeTask(taskId);
    }

    @Override
    public Task updateTask(Task task) {
        return database.updateTask(task);
    }

    @Override
    public Task addTask(Task task) {
        return database.addTask(task);
    }
    
}