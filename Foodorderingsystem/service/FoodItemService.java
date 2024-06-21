package Foodorderingsystem.service;

import Foodorderingsystem.model.FoodItem;

public interface FoodItemService {
    String addFoodItem(String restaurantId,String name,String description,String price,boolean availabilty);
    FoodItem updateFoodItem(String foodItemId,String price,boolean availabilty);
    FoodItem deleteFoodItem(String foodItemId);
    FoodItem getFoodItemsByRestaurantId(String restaurantId);
}
