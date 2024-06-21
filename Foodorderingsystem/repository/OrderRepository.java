package Foodorderingsystem.repository;

import Foodorderingsystem.model.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
    Order findByCustomerId(String customerId);
    Order findByRestaurantId(String restaurantId);
    Order findByOrderId(String orderId);
}
