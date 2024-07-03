package Foodorderingsystem.service.impl;

import Foodorderingsystem.Helper;
import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.impl.RestaurantRepositoryImpl;
import Foodorderingsystem.service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    public static RestaurantServiceImpl restaurantService = null;

    public static synchronized RestaurantServiceImpl getInstance() {
        if (restaurantService == null) {
            restaurantService = new RestaurantServiceImpl();
        }
        return restaurantService;
    }

    private RestaurantServiceImpl() {

    }

    RestaurantRepositoryImpl restaurantRepository = RestaurantRepositoryImpl.getInstance();
    UserServiceImpl userService = UserServiceImpl.getInstance();
    static int id = 0;

    @Override
    public Restaurant createRestaurant(String ownerId, String name, String address, String phone) {
        if (!Helper.validate_phoneNo(phone)) {
            return null;
        }
        User user = userService.getUserByUserId(ownerId);
        if (user != null && user.getRole().equals("OWNER")) {
            Restaurant restaurant = new Restaurant("Restaurant" + (++id), ownerId, name, address, phone);
            restaurantRepository.saveRestaurant(restaurant);

            return restaurant;
        }
        System.out.println("here");
        return null;
    }

    @Override
    public Restaurant updateRestaurant(String ownerId, String restaurantId, String name, String address) {
        User user = userService.getUserByUserId(ownerId);
        if (user != null && user.getRole().equals("OWNER")) {

            return restaurantRepository.updateRestaurant(restaurantId, name, address);
        }
        return null;
    }

    @Override
    public boolean deleteRestaurant(String ownerId, String restaurantId) {

        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        if (restaurant.getOwnerId().equals(ownerId)) {
            return restaurantRepository.removeRestaurant(restaurantId);
        }
        return false;
    }

    @Override
    public Restaurant getRestaurantByOwnerId(String ownerId) {

        return restaurantRepository.findByRestaurantId(ownerId);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.getAllRestaurant();
    }

    @Override
    public Restaurant addFoodItems(String ownerId, List<FoodItem> foodItems) {
        for (int i = 0; i < foodItems.size(); i++) {
            for (int j = i; j < foodItems.size(); j++) {
                if (foodItems.get(i).getName().equals(foodItems.get(j).getName())) {
                    foodItems.remove(foodItems.get(j));
                }
            }
        }
        Restaurant restaurant = restaurantRepository.getRestaurantByRestaurantId(foodItems.getFirst().getRestaurantId());
        if (restaurant.getOwnerId().equals(ownerId)) {
            for (FoodItem foodItem : restaurant.getFoodItems()) {

                for (int i = 0; i < foodItems.size(); i++) {
                    if (foodItem.getName().equals(foodItems.get(i).getName())) {
                        foodItems.remove(foodItems.get(i));
                    }
                }

            }
            if (foodItems.isEmpty()) {
                return null;
            }
            return restaurantRepository.addFoodItems(ownerId, foodItems);
        }
        return null;
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(String ownerId, String restaurantId) {
        if (ownerId.equals(restaurantRepository.getRestaurantByRestaurantId(restaurantId).getOwnerId())) {
            return restaurantRepository.getRestaurantByRestaurantId(restaurantId);
        }
        return null;
    }
}
