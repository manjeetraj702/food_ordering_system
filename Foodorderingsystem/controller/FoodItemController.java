package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.service.impl.FoodItemServiceImpl;

public class FoodItemController {
    FoodItemServiceImpl foodItemService=FoodItemServiceImpl.getInstance();
   public String addFoodItem(String id, String restaurantId, String name, String description, String price, boolean availabilty)
    {
        return foodItemService.addFoodItem(restaurantId,name,description,price,availabilty);
    }
    public FoodItem updateFoodItem(String foodItemId,String price,boolean availabilty){
        return foodItemService.updateFoodItem(foodItemId,price,availabilty);
    }
    public FoodItem deleteFoodItem(String foodItemId){
        return foodItemService.deleteFoodItem(foodItemId);
    }

    public FoodItem getFoodItemsByRestaurantId(String restaurantId){
        return foodItemService.getFoodItemsByRestaurantId(restaurantId);
    }
}
