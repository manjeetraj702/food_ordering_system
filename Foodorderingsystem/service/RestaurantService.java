package Foodorderingsystem.service;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(String id,String ownerId,String name,String address,String phone,List<FoodItem> foodItems);
    Restaurant updateRestaurant(String restaurantId,List<FoodItem> foodItems);
    boolean deleteRestaurant(String restaurantId);
    Restaurant getRestaurantByOwnerId(String ownerId);
}
