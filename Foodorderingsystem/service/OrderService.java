package Foodorderingsystem.service;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOder(String customerId,String restaurantId,List<FoodItem> foodItems,String totalPrice);
    List<Order> getOrdersByCustomerId(String customerId);
    List<Order> getOrdersByRestaurantId(String ownerId,String restaurantId);
    Order updateOrderStatus(String ownerId,String orderId,String status);
}
