package Foodorderingsystem.repository.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    private List<Restaurant> restaurantList=new ArrayList<>();
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
    public Restaurant updateRestaurant(String restaurantId,List<FoodItem> foodItems) {
        for(Restaurant restaurant:restaurantList)
        {
            if(restaurant.getId().equals(restaurantId)) {
                restaurant.setFoodItems(foodItems);
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
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantList;
    }
}
