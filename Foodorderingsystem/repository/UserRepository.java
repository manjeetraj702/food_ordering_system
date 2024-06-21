package Foodorderingsystem.repository;

import Foodorderingsystem.model.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);
    User findByUserName(String userName);
    User findByEmail(String email);
    User findByUserId(String userId);
    List<User> getListOfUser();
}
