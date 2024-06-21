package Foodorderingsystem.repository;

import Foodorderingsystem.model.FoodItem;

public interface FoodItemRepository {
    FoodItem saveFoodItem(FoodItem foodItem);
    FoodItem findByRestaurantId(String restaurantId);
}
