package Foodorderingsystem.controller;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;
import Foodorderingsystem.service.impl.OrderServiceImpl;

import java.util.List;

public class OrderController {
    public static OrderController orderController = null;

    public static synchronized OrderController getInstance() {
        if (orderController == null) {
            orderController = new OrderController();
        }
        return orderController;
    }

    private OrderController() {

    }

    OrderServiceImpl orderService = OrderServiceImpl.getInstance();

    public Order placeOrder(String customerId, String restaurantId, List<FoodItem> foodItems, String totalPrice) {
        return orderService.placeOder(customerId, restaurantId, foodItems, totalPrice);
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    public List<Order> getOrdersByRestaurantId(String ownerId, String restaurantId) {
        return orderService.getOrdersByRestaurantId(ownerId, restaurantId);
    }

    public Order updateOrderStatus(String ownerId, String orderId, String status) {
        return orderService.updateOrderStatus(orderId, orderId, status);
    }
}
