package edu.eci.ieti.taskPlannerBack.Entities;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    List<Task> geTasksList();
    
    Task getTaskById(String id);
    
    List<Task> getTasksByUserId(String userId);
    
    Task assignTaskToUser(String taskId, User user);
    
    void removeTask(String taskId);
    
    Task updateTask(Task task);
}