package Foodorderingsystem.service.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;
import Foodorderingsystem.repository.impl.OrderRepositoryImpl;
import Foodorderingsystem.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderRepositoryImpl orderRepository=new OrderRepositoryImpl();
    static OrderServiceImpl orderService=null;
    public static OrderServiceImpl getInstance()
    {
        if(orderService==null)
        {
            orderService=new OrderServiceImpl();
            return orderService;
        }
        return  orderService;
    }
    static int id=0;

    RestaurantServiceImpl restaurantService=RestaurantServiceImpl.getInstance();
    @Override
    public Order placeOder( String customerId, String restaurantId, List<FoodItem> foodItems, String totalPrice, String status) {
        Order order=new Order("order"+(++id),customerId,restaurantId,foodItems,totalPrice,status);
        orderRepository.saveOrder(order);
        return order;
    }

    @Override
    public List<Order> getOrdersByCustomerId(String customerId) {
        List<Order> order=orderRepository.findByCustomerId(customerId);
        if(order!=null)
        {
            return order;
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByRestaurantId(String restaurantId) {
        List<Order> order=orderRepository.findByRestaurantId(restaurantId);
        if(order!=null)
        {
            return order;
        }
        return null;
    }

    @Override
    public Order updateOrderStatus(String orderId, String status) {
        Order order=orderRepository.findByOrderId(orderId);
        order.setStatus(status);
        return null;
    }
}
