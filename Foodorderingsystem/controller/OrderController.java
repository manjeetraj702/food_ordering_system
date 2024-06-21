package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;
import Foodorderingsystem.service.impl.OrderServiceImpl;

import java.util.List;

public class OrderController {
    OrderServiceImpl orderService=OrderServiceImpl.getInstance();
    Order placeOder(String id, String customerId, String restaurantId, List<FoodItem> foodItems, String totalPrice, String status)
    {
        return orderService.placeOder(id,customerId,restaurantId,foodItems,totalPrice,status);
    }
    Order getOrdersByCustomerId(String customerId){
        return orderService.getOrdersByCustomerId(customerId);
    }

    Order getOrdersByRestaurantId(String restaurantId){
        return orderService.getOrdersByRestaurantId(restaurantId);
    }
    Order updateOrderStatus(String orderId,String status){
        return orderService.updateOrderStatus(orderId,status);
    }
}
