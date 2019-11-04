package edu.eci.ieti.taskPlannerBack.Entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.ieti.taskPlannerBack.Persistence.UserMongoRepo;
import edu.eci.ieti.taskPlannerBack.Persistence.databaseConnection;



@Component
public class UserServiceImpl implements UserServices {
    @Autowired
    UserMongoRepo database;

    @Override
    public List<User> getUsersList() {
        return database.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return database.findByEmail(userId);
    }

    @Override
    public User createUser(User user) {
        return database.save(user);
    }

    @Override
    public User updateUser(User user) {
        return database.save(user);
    }

    @Override
    public void removeUser(String userId) {
        database.deleteById(userId);
    }

}