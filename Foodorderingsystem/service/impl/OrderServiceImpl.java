package Foodorderingsystem.service.impl;

import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.model.User;
import Foodorderingsystem.repository.impl.OrderRepositoryImpl;
import Foodorderingsystem.service.OrderService;
import Foodorderingsystem.service.UserService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    public static OrderServiceImpl orderService = null;

    public static synchronized OrderServiceImpl getInstance() {
        if (orderService == null) {
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }

    private OrderServiceImpl() {

    }

    OrderRepositoryImpl orderRepository = OrderRepositoryImpl.getInstance();
    RestaurantServiceImpl restaurantService = RestaurantServiceImpl.getInstance();
    UserServiceImpl userService = UserServiceImpl.getInstance();
    static int id = 0;

    @Override
    public Order placeOder(String customerId, String restaurantId, List<FoodItem> foodItems, String totalPrice) {
        if (foodItems.isEmpty()) {
            System.out.println("There is not food items in order placed.");
            return null;
        }
        User user = userService.getUserByUserId(customerId);
        if (user == null || user.getRole() != "CUSTOMER") {
            return null;
        }
        Order order = new Order("order" + (++id), customerId, restaurantId, foodItems, totalPrice);
        orderRepository.saveOrder(order);
        return order;
    }

    @Override
    public List<Order> getOrdersByCustomerId(String customerId) {
        List<Order> order = orderRepository.findByCustomerId(customerId);
        if (order != null) {
            return order;
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByRestaurantId(String ownerId, String restaurantId) {
        User user = UserServiceImpl.getInstance().getUserByUserId(ownerId);
        Restaurant restaurant = restaurantService.getRestaurantByOwnerId(ownerId);
        if (user != null && restaurant != null && restaurant.getOwnerId().equals(ownerId)) {
            List<Order> order = orderRepository.findByRestaurantId(restaurantId);
            if (order != null) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order updateOrderStatus(String ownerId, String orderId, String status) {
        Order order = orderRepository.findByOrderId(orderId);
        Restaurant restaurant=restaurantService.getRestaurantByRestaurantId(ownerId,order.getRestaurantId());
        if (restaurant != null) {
                order.setStatus(status);
        }

        return null;
    }
}
