package Foodorderingsystem.repository.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    private List<Restaurant> restaurantList=new ArrayList<>();
private List<Restaurant> deletedRestaurantList=new ArrayList<>();

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant findByRestaurantId(String ownerId) {
        for(Restaurant restaurant:restaurantList)
        {
            if(restaurant.getOwnerId().equals(ownerId)) return restaurant;
        }
        return null;
    }

    @Override
    public Restaurant updateRestaurant(String restaurantId,String name, String address) {
        for(Restaurant restaurant:restaurantList)
        {
            if(restaurant.getId().equals(restaurantId)) {
                restaurant.setName(name);
                restaurant.setAddress(address);
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public boolean removeRestaurant(String restaurantId) {
        for(Restaurant restaurant:restaurantList)
        {
            if(restaurant.getId().equals(restaurantId)) {
                restaurantList.remove(restaurant);
deletedRestaurantList.add(restaurant);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantList;
    }

    @Override
    public Restaurant addFoodItems(String ownerId, List<FoodItem> foodItems) {
        for(Restaurant restaurant:restaurantList)
        {
            if(restaurant.getOwnerId().equals(ownerId))
            {
                restaurant.addFoodItems(foodItems);
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(String restaurantId) {
        for(Restaurant restaurant:restaurantList)
        {
            if(restaurant.getId().equals(restaurantId))
            {
                return  restaurant;
            }
        }
        return null;
    }
}
