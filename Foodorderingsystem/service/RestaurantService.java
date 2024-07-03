package Foodorderingsystem.service;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(String ownerId, String name, String address, String phone);

    Restaurant updateRestaurant(String ownerId, String restaurantId, String name, String address);

    boolean deleteRestaurant(String ownerId, String restaurantId);

    Restaurant getRestaurantByOwnerId(String ownerId);

    List<Restaurant> getAllRestaurant();

    Restaurant addFoodItems(String ownerId, List<FoodItem> foodItems);

    Restaurant getRestaurantByRestaurantId(String ownerId,String restaurantId);
}
