package Foodorderingsystem.service.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.impl.FoodItemRepositoryImpl;
import Foodorderingsystem.service.FoodItemService;

public class FoodItemServiceImpl implements FoodItemService {
    FoodItemRepositoryImpl foodItemRepository=new FoodItemRepositoryImpl();
    static FoodItemServiceImpl instance=null;
    public static FoodItemServiceImpl getInstance()
    {
        if(instance==null)
        {
            instance=new FoodItemServiceImpl();
            return instance;
        }
        return instance;
    }
    static int id=0;
    UserServiceImpl userService=UserServiceImpl.getInstance();
    @Override
    public FoodItem addFoodItem( String ownerId,String restaurantId, String name, String description, String price, boolean availabilty) {
        User user=userService.getUserByUserId(ownerId);
        if(user== null || user.getRole()!="OWNER")
        {
            return null;
        }
        FoodItem foodItem=new FoodItem("food"+(++id),restaurantId,name,description,price,availabilty);
        foodItemRepository.saveFoodItem(foodItem);
        return foodItem;
    }

    @Override
    public FoodItem updateFoodItem(String ownerId,String foodItemId, String price,boolean availabilty) {
        User user=userService.getUserByUserId(ownerId);
        if(user== null || user.getRole()!="OWNER")
        {
            return null;
        }
        FoodItem foodItem= foodItemRepository.findByFoodItemId(foodItemId);
        if(foodItem!=null)
        {
            foodItem.setAvailabilty(availabilty);
            foodItem.setPrice(price);
            return foodItem;
        }

        return null;
    }

    @Override
    public FoodItem deleteFoodItem(String ownerId,String foodItemId) {
        User user=userService.getUserByUserId(ownerId);
        if(user== null || user.getRole()!="OWNER")
        {
            return null;
        }
        FoodItem foodItem=foodItemRepository.removeFoodItemId(foodItemId);
        if(foodItem!=null)
        {
            return foodItem;
        }
        return null;
    }

    @Override
    public FoodItem getFoodItemsByRestaurantId(String restaurantId) {
        FoodItem foodItem=foodItemRepository.findByRestaurantId(restaurantId);
        if(foodItem!=null)
        {
            return foodItem;
        }
        return null;
    }
}
