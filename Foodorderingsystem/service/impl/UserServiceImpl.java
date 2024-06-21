package Foodorderingsystem.service.impl;

import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.impl.UserRepositoryImpl;
import Foodorderingsystem.service.UserService;

public class UserServiceImpl implements UserService {
    static UserServiceImpl userService=null;
    static UserServiceImpl getInstance()
    {
        if(userService==null) {
            userService=new UserServiceImpl();
            return userService;
        }
        return userService;
    }
    static int id=0;
    UserRepositoryImpl userRepository=new UserRepositoryImpl();
    @Override
    public String register(String userName,String password,String email,String role) {
        for(User user:userRepository.getListOfUser())
        {
            if(user.getUserName().equals(userName))
            {
                return "Username already exist";
            }
            if (user.getEmail().equals(email))
            {
                return "EmailId already exist";
            }
        }
        User user=new User("user"+(++id),userName,password,email,role);
        userRepository.saveUser(user);
        return "Your userid is  "+id;
    }

    @Override
    public String login(String userName, String password) {
        User user=userRepository.findByUserName(userName);
        if(user!=null){
            if(user.getPassword().equals(password) && user.getRole().equals("OWNER")){
                return "Successfully login as owner";}
            else if(user.getPassword().equals(password) ){
                return "Successfully login as customer";}
            else {
                return "Password is incorrect";
            }
        }
        return "Username is invalid";
    }

    @Override
    public User getUserProfile(String userId) {
        User user=userRepository.findByUserId(userId);
        if(user!=null) {return user;}

        return null;
    }
}
