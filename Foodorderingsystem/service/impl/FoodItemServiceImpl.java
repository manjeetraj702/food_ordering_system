package Foodorderingsystem.service.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.impl.FoodItemRepositoryImpl;
import Foodorderingsystem.repository.impl.UserRepositoryImpl;
import Foodorderingsystem.service.FoodItemService;

public class FoodItemServiceImpl implements FoodItemService {
    public static FoodItemServiceImpl foodItemService = null;

    public static synchronized FoodItemServiceImpl getInstance() {
        if (foodItemService == null) {
            foodItemService = new FoodItemServiceImpl();
        }
        return foodItemService;
    }

    private FoodItemServiceImpl() {

    }

    FoodItemRepositoryImpl foodItemRepository = FoodItemRepositoryImpl.getInstance();

    static int id = 0;
    UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public FoodItem addFoodItem(String ownerId, String restaurantId, String name, String description, String price, boolean availabilty) {
        User user = userService.getUserByUserId(ownerId);
        if (user == null || user.getRole() != "OWNER") {
            return null;
        }
        FoodItem foodItem = new FoodItem("food" + (++id), restaurantId, name, description, price, availabilty);
        foodItemRepository.saveFoodItem(foodItem);
        return foodItem;
    }

    @Override
    public FoodItem updateFoodItem(String ownerId, String foodItemId, String price, boolean availabilty) {
        User user = userService.getUserByUserId(ownerId);
        if (user == null || user.getRole() != "OWNER") {
            return null;
        }
        FoodItem foodItem = foodItemRepository.findByFoodItemId(foodItemId);
        if (foodItem != null) {
            foodItem.setAvailabilty(availabilty);
            foodItem.setPrice(price);
            return foodItem;
        }

        return null;
    }

    @Override
    public FoodItem deleteFoodItem(String ownerId, String foodItemId) {
        User user = userService.getUserByUserId(ownerId);
        if (user == null || user.getRole() != "OWNER") {
            return null;
        }
        FoodItem foodItem = foodItemRepository.removeFoodItemId(foodItemId);
        if (foodItem != null) {
            return foodItem;
        }
        return null;
    }

    @Override
    public FoodItem getFoodItemsByRestaurantId(String restaurantId) {
        FoodItem foodItem = foodItemRepository.findByRestaurantId(restaurantId);
        if (foodItem != null) {
            return foodItem;
        }
        return null;
    }
}
