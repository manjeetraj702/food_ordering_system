package Foodorderingsystem.service.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.repository.impl.RestaurantRepositoryImpl;
import Foodorderingsystem.service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepositoryImpl restaurantRepository=new RestaurantRepositoryImpl();
    static RestaurantServiceImpl restaurantService=null;
    static RestaurantServiceImpl getInstance()
    {
        if(restaurantService==null)
        {
            restaurantService=new RestaurantServiceImpl();
            return restaurantService;
        }
        return restaurantService;
    }
    static int id=0;
    @Override
    public Restaurant createRestaurant( String ownerId, String name, String address, String phone, List<FoodItem> foodItems) {
        Restaurant restaurant=new Restaurant("Restaurant"+(++id),ownerId,name,address,phone,foodItems);
        restaurantRepository.saveRestaurant(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant updateRestaurant(String restaurantId,List<FoodItem> foodItems) {

        return restaurantRepository.updateRestaurant(restaurantId,foodItems);
    }

    @Override
    public boolean deleteRestaurant(String restaurantId) {
        
        return restaurantRepository.removeRestaurant(restaurantId);
    }

    @Override
    public Restaurant getRestaurantByOwnerId(String ownerId) {

        return restaurantRepository.findByRestaurantId(ownerId);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.getAllRestaurant();
    }
}
