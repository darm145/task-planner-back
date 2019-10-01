package edu.eci.ieti.taskPlannerBack.Entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.ieti.taskPlannerBack.databaseConnection;

@Component
public class UserServiceImpl implements UserServices {
    @Autowired
    databaseConnection database;

    @Override
    public List<User> getUsersList() {
        return database.getUsersList();
    }

    @Override
    public User getUserById(String userId) {
        return database.getUserById(userId);
    }

    @Override
    public User createUser(User user) {
        return database.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return database.updateUser(user);
    }

    @Override
    public void removeUser(String userId) {
        database.removeUser(userId);
    }

}