package Foodorderingsystem.repository;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant saveRestaurant(Restaurant restaurant);
    Restaurant findByRestaurantId(String ownerId);
    Restaurant updateRestaurant(String restaurantId, String name, String address);
    boolean removeRestaurant(String restaurantId);

    List<Restaurant> getAllRestaurant();
}
