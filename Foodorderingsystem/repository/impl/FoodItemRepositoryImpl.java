package Foodorderingsystem.repository.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.repository.FoodItemRepository;

import java.util.ArrayList;
import java.util.List;


public class FoodItemRepositoryImpl implements FoodItemRepository {
    public static FoodItemRepositoryImpl foodItemRepository = null;

    public static synchronized FoodItemRepositoryImpl getInstance() {
        if (foodItemRepository == null) {
            foodItemRepository = new FoodItemRepositoryImpl();
        }
        return foodItemRepository;
    }

    private FoodItemRepositoryImpl() {

    }

    private List<FoodItem> foodItems = new ArrayList<>();

    @Override
    public FoodItem saveFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
        return foodItem;
    }

    @Override
    public FoodItem findByRestaurantId(String restaurantId) {
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getRestaurantId().equals(restaurantId)) return foodItem;
        }
        return null;
    }

    public FoodItem findByFoodItemId(String foodItemId) {
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getId().equals(foodItemId)) return foodItem;
        }
        return null;
    }

    public FoodItem removeFoodItemId(String foodItemId) {
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getId().equals(foodItemId)) {
                foodItems.remove(foodItem);
                return foodItem;
            }
        }
        return null;
    }

}
