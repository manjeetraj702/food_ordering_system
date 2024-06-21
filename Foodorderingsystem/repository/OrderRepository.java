package Foodorderingsystem.repository;

import Foodorderingsystem.model.Order;

import java.util.List;

public interface OrderRepository {
    Order saveOrder(Order order);
    List<Order> findByCustomerId(String customerId);
    List<Order> findByRestaurantId(String restaurantId);
    Order findByOrderId(String orderId);
}
