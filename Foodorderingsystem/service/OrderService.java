package Foodorderingsystem.service;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOder(String id,String customerId,String restaurantId,List<FoodItem> foodItems,String totalPrice,String status);
    Order getOrdersByCustomerId(String customerId);
    Order getOrdersByRestaurantId(String restaurantId);
    Order updateOrderStatus(String orderId,String status);
}
