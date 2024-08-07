package Foodorderingsystem.controller;

import Foodorderingsystem.model.User;
import Foodorderingsystem.service.impl.UserServiceImpl;

public class UserController {
    public static UserController userController = null;

    public static synchronized UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    private UserController() {

    }

    UserServiceImpl userService = UserServiceImpl.getInstance();

    public String register(String userName, String password, String email, String role) {
        return userService.register(userName, password, email, role);
    }

    public User login(String userName, String password) {
        return userService.login(userName, password);
    }

    public User getUserProfile(String userId) {
        return userService.getUserByUserId(userId);
    }
}
