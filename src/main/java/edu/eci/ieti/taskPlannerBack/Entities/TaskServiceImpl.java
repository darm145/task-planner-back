package edu.eci.ieti.taskPlannerBack.Entities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.ieti.taskPlannerBack.Persistence.TaskMongoCustomRepo;
import edu.eci.ieti.taskPlannerBack.Persistence.TaskMongoRepo;
import edu.eci.ieti.taskPlannerBack.Persistence.UserMongoRepo;
import edu.eci.ieti.taskPlannerBack.Persistence.databaseConnection;



@Component
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMongoRepo database;
    @Autowired
    TaskMongoCustomRepo custom;
    @Autowired
    UserMongoRepo userdb;

    @Override
    public List<Task> geTasksList() {
        return database.findAll();
    }

    @Override
    public Task getTaskById(String id) {
        Optional<Task> response=database.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return custom.findAllByOwner(userId);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        return custom.assignTaskToUser(taskId, user);
    }

    @Override
    public void removeTask(String taskId) {
        database.deleteById(taskId);
    }

    @Override
    public Task updateTask(Task task) {
        return database.save(task);
    }

    @Override
    public Task addTask(Task task) {
        return database.save(task);
    }
    
}