package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;
import Foodorderingsystem.service.impl.OrderServiceImpl;

import java.util.List;

public class OrderController {
    OrderServiceImpl orderService=OrderServiceImpl.getInstance();
    public Order placeOder(String id, String customerId, String restaurantId, List<FoodItem> foodItems, String totalPrice, String status)
    {
        return orderService.placeOder(customerId,restaurantId,foodItems,totalPrice,status);
    }
    public List<Order> getOrdersByCustomerId(String customerId){
        return orderService.getOrdersByCustomerId(customerId);
    }

    public List<Order> getOrdersByRestaurantId(String restaurantId){
        return orderService.getOrdersByRestaurantId(restaurantId);
    }
    public Order updateOrderStatus(String orderId,String status){
        return orderService.updateOrderStatus(orderId,status);
    }
}
