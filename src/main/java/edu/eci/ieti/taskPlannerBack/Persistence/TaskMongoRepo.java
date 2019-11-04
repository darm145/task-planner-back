package edu.eci.ieti.taskPlannerBack.Persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.taskPlannerBack.Entities.Task;





public interface TaskMongoRepo extends MongoRepository<Task, String> {
   
}