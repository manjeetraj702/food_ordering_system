package Foodorderingsystem.service;

import Foodorderingsystem.model.FoodItem;

public interface FoodItemService {
    FoodItem addFoodItem(String ownerId,String restaurantId,String name,String description,String price,boolean availabilty);
    FoodItem updateFoodItem(String ownerId,String foodItemId,String price,boolean availabilty);
    FoodItem deleteFoodItem(String ownerId,String foodItemId);
    FoodItem getFoodItemsByRestaurantId(String restaurantId);
}
