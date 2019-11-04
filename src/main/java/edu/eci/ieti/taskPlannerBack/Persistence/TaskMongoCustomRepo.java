
package edu.eci.ieti.taskPlannerBack.Persistence;

import edu.eci.ieti.taskPlannerBack.Entities.User;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.taskPlannerBack.Entities.Task;
@Service
public interface TaskMongoCustomRepo {
    Task assignTaskToUser(String taskId, User user);
    List<Task> findAllByOwner(String owner);
   
}




