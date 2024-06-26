package Foodorderingsystem.service.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.impl.RestaurantRepositoryImpl;
import Foodorderingsystem.service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepositoryImpl restaurantRepository=new RestaurantRepositoryImpl();
    static RestaurantServiceImpl restaurantService=null;
    public static RestaurantServiceImpl getInstance()
    {
        if(restaurantService==null)
        {
            restaurantService=new RestaurantServiceImpl();
        }
        return restaurantService;
    }
    static int id=0;
    UserServiceImpl userService=UserServiceImpl.getInstance();
    @Override
    public Restaurant createRestaurant( String ownerId, String name, String address, String phone) {
        User user=userService.getUserByUserId(ownerId);
        if(user!=null && user.getRole().equals("OWNER")) {
            Restaurant restaurant = new Restaurant("Restaurant" + (++id), ownerId, name, address, phone);
            restaurantRepository.saveRestaurant(restaurant);

            return restaurant;
        }
        System.out.println("here");
        return null;
    }

    @Override
    public Restaurant updateRestaurant(String ownerId,String restaurantId,String name, String address) {

        return restaurantRepository.updateRestaurant(restaurantId,name, address);
    }

    @Override
    public boolean deleteRestaurant(String ownerId,String restaurantId) {
        
        return restaurantRepository.removeRestaurant(restaurantId);
    }

    @Override
    public Restaurant getRestaurantByOwnerId(String ownerId) {

        return restaurantRepository.findByRestaurantId(ownerId);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.getAllRestaurant();
    }

    @Override
    public Restaurant addFoodItems(String ownerId, List<FoodItem> foodItems) {

        return restaurantRepository.addFoodItems(ownerId,foodItems);
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(String restaurantId) {
        return restaurantRepository.getRestaurantByRestaurantId(restaurantId);
    }
}
