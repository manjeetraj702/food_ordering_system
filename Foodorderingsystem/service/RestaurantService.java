package Foodorderingsystem.service;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(String ownerId,String name,String address,String phone);
    Restaurant updateRestaurant(String restaurantId,String name, String address);
    boolean deleteRestaurant(String restaurantId);
    Restaurant getRestaurantByOwnerId(String ownerId);

    List<Restaurant> getAllRestaurant();

    void addFoodItems(String ownerId, List<FoodItem> foodItems);
}
