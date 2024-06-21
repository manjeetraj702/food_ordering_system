package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.service.impl.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    RestaurantServiceImpl restaurantService =new RestaurantServiceImpl();
    Restaurant createRestaurant(String id, String ownerId, String name, String address, String phone, List<FoodItem> foodItems)
    {
        return createRestaurant(id,ownerId,name,address,phone,foodItems);
    }
    Restaurant updateRestaurant(String restaurantId,List<FoodItem> foodItems){
        return updateRestaurant(restaurantId,foodItems);
    }
    boolean deleteRestaurant(String restaurantId){
        return  deleteRestaurant(restaurantId);
    }
    Restaurant getRestaurantByOwnerId(String ownerId){
        return getRestaurantByOwnerId(ownerId);
    }
}
