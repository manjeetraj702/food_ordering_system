package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.service.impl.FoodItemServiceImpl;

public class FoodItemController {
    FoodItemServiceImpl foodItemService=FoodItemServiceImpl.getInstance();
   public FoodItem addFoodItem( String ownerId,String restaurantId, String name, String description, String price, boolean availabilty)
    {
        return foodItemService.addFoodItem(ownerId,restaurantId,name,description,price,availabilty);
    }
    public FoodItem updateFoodItem(String ownerId,String foodItemId,String price,boolean availabilty){
        return foodItemService.updateFoodItem( ownerId,foodItemId,price,availabilty);
    }
    public FoodItem deleteFoodItem(String ownerId,String foodItemId){
        return foodItemService.deleteFoodItem(ownerId,foodItemId);
    }

    public FoodItem getFoodItemsByRestaurantId(String restaurantId){
        return foodItemService.getFoodItemsByRestaurantId(restaurantId);
    }
}
