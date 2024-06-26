package Foodorderingsystem.repository.impl;

import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> userList=new ArrayList<>();

    @Override
    public User saveUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User findByUserName(String userName) {
        for(User user:userList)
        {
            if(user.getUserName().equals(userName)) return user;
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        for(User user:userList)
        {
            if(user.getEmail().equals(email)) return user;
        }
        return null;
    }
    public User findByUserId(String userId)
    {
        for(User user:userList)
        {
            if(user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getListOfUser() {
        return userList;
    }
}
