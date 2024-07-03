package Foodorderingsystem.repository.impl;

import Foodorderingsystem.model.Order;
import Foodorderingsystem.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    public static OrderRepositoryImpl orderRepository = null;

    public static synchronized OrderRepositoryImpl getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }

    private OrderRepositoryImpl() {

    }

    private List<Order> orderList = new ArrayList<>();

    @Override
    public Order saveOrder(Order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public List<Order> findByCustomerId(String customerId) {
        List<Order> orderList1 = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getCustomerId().equals(customerId)) {
                orderList1.add(order);
            }
        }
        return orderList1;
    }

    @Override
    public List<Order> findByRestaurantId(String restaurantId) {
        List<Order> orderList1 = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getRestaurantId().equals(restaurantId)) {
                orderList1.add(order);
            }
        }
        return orderList1;
    }

    @Override
    public Order findByOrderId(String orderId) {
        for (Order order : orderList) {
            if (order.getId().equals(orderId)) return order;
        }
        return null;
    }
}
