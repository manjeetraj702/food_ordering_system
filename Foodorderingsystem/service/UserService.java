package Foodorderingsystem.service;

import Foodorderingsystem.model.User;

public interface UserService {
    String register( String userName,String password,String email,String role);
    User login(String userName,String password);
    User getUserProfile(String userId);
}
