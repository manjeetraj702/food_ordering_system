package Foodorderingsystem.repository.impl;

import Foodorderingsystem.model.Order;
import Foodorderingsystem.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private List<Order> orderList=new ArrayList<>();
    @Override
    public Order saveOrder(Order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public Order findByCustomerId(String customerId) {
        for(Order order:orderList)
        {
            if(order.getCustomerId().equals(customerId)) return order;
        }
        return null;
    }

    @Override
    public Order findByRestaurantId(String restaurantId) {
        for(Order order:orderList)
        {
            if(order.getRestaurantId().equals(restaurantId)) return  order;
        }
        return null;
    }

    @Override
    public Order findByOrderId(String orderId) {
        for(Order order:orderList)
        {
            if(order.getId().equals(orderId)) return  order;
        }
        return null;
    }
}
