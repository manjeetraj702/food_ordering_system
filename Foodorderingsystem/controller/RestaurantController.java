package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.service.impl.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    RestaurantServiceImpl restaurantService =new RestaurantServiceImpl();
    public Restaurant createRestaurant( String ownerId, String name, String address, String phone)
    {
        return restaurantService.createRestaurant(ownerId,name,address,phone);
    }
    public Restaurant updateRestaurant(String restaurantId, String name, String address){
        return restaurantService.updateRestaurant(restaurantId,  name,  address);
    }
    public boolean deleteRestaurant(String restaurantId){
        return  restaurantService.deleteRestaurant(restaurantId);
    }
    public Restaurant getRestaurantByOwnerId(String ownerId){
        return restaurantService.getRestaurantByOwnerId(ownerId);
    }
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    public void addFoodItems(String ownerId, List<FoodItem> foodItems) {
        restaurantService.addFoodItems(ownerId,foodItems);
    }
}
