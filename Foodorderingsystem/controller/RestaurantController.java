package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.service.impl.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    RestaurantServiceImpl restaurantService =new RestaurantServiceImpl();
    Restaurant createRestaurant( String ownerId, String name, String address, String email, List<FoodItem> foodItems)
    {
        return restaurantService.createRestaurant(ownerId,name,address,email,foodItems);
    }
    Restaurant updateRestaurant(String restaurantId,List<FoodItem> foodItems){
        return restaurantService.updateRestaurant(restaurantId,foodItems);
    }
    boolean deleteRestaurant(String restaurantId){
        return  restaurantService.deleteRestaurant(restaurantId);
    }
    Restaurant getRestaurantByOwnerId(String ownerId){
        return restaurantService.getRestaurantByOwnerId(ownerId);
    }
    List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }
}
