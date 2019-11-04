package edu.eci.ieti.taskPlannerBack.Persistence;

import edu.eci.ieti.taskPlannerBack.Entities.User;
import edu.eci.ieti.taskPlannerBack.config.AppConfiguration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import edu.eci.ieti.taskPlannerBack.Entities.Task;
@Component
public class CustomTaskImpl implements TaskMongoCustomRepo{
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
    MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
    public Task assignTaskToUser(String taskId, User user){
        Query q=new Query();
        q.addCriteria(Criteria.where("Id").is(taskId));
        Task tempTask= mongoOperation.findOne(q, Task.class);
        tempTask.setOwner(user);
        mongoOperation.save(tempTask);
        return tempTask;
    }
    public List<Task> findAllByOwner(String owner){
        ArrayList<Task> tasks = new ArrayList<Task>();
        for(Task t:mongoOperation.findAll(Task.class)){
            if (t.getOwner().getEmail().equals(owner)){
                tasks.add(t);
            }
        }
        return tasks;

    }
   
}
