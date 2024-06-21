package Foodorderingsystem.controller;

import Foodorderingsystem.model.User;
import Foodorderingsystem.service.impl.UserServiceImpl;

public class UserController {
    UserServiceImpl userService=new UserServiceImpl();
    String register( String userName, String password, String email, String role)
    {
         return userService.register(userName,password,email,role);
    }
    User login(String userName,String password)
    {
        return userService.login(userName,password);
    }
    User getUserProfile(String userId)
    {
        return userService.getUserProfile(userId);
    }
}
