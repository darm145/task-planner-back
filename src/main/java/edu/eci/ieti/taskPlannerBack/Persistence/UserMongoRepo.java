package edu.eci.ieti.taskPlannerBack.Persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.taskPlannerBack.Entities.User;




public interface UserMongoRepo extends MongoRepository<User, String> {
    User findByEmail(String email);
}