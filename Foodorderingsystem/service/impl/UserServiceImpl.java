package Foodorderingsystem.service.impl;

import Foodorderingsystem.Helper;
import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.impl.UserRepositoryImpl;
import Foodorderingsystem.service.UserService;

public class UserServiceImpl implements UserService {
    public static UserServiceImpl userService = null;

    public static synchronized UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    private UserServiceImpl() {

    }

    UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();
    static int id = 0;

    @Override
    public String register(String userName, String password, String email, String role) {
        if (!Helper.validate_password(password)) {
            return "";
        }
        if (!Helper.validate_emailId(email)) {
            return "";
        }
        for (User user : userRepository.getListOfUser()) {
            if (user.getUserName().equals(userName)) {
                return "Username already exist";
            }
            if (user.getEmail().equals(email)) {
                return "EmailId already exist";
            }
        }
        User user = new User("user" + (++id), userName, password, email, role);
        userRepository.saveUser(user);
        return "Your userid is  " + "user" + id + "\nsuccessfully signup";
    }

    @Override
    public User login(String userName, String password) {
        if (!Helper.validate_password(password)) {
            return null;
        }
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            if (user.getPassword().equals(password) && user.getRole().equals("OWNER")) {
                System.out.println("Successfully login as owner");
                return user;
            } else if (user.getPassword().equals(password)) {
                System.out.println("Successfully login as customer");
                return user;
            } else {
                System.out.println("Password is incorrect");
                return null;
            }
        }
        System.out.println("Username is invalid");
        return null;
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);

    }
}
