package edu.eci.ieti.taskPlannerBack;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.taskPlannerBack.Entities.Task;
import edu.eci.ieti.taskPlannerBack.Entities.User;

@Service
public interface databaseConnection{
    List<Task> geTasksList();
    
    Task getTaskById(String id);
    
    List<Task> getTasksByUserId(String userId);
    
    Task assignTaskToUser(String taskId, User user);
    
    void removeTask(String taskId);
    
    Task updateTask(Task task);
    List<User> getUsersList();
    
    User getUserById(String userId);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);

	Task addTask(Task task);
    
}
