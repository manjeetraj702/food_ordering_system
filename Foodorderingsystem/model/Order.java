package Foodorderingsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private String restaurantId;
    private List<FoodItem> foodItems=new ArrayList<>();
    private String totalPrice;
    private String status;
    public String toString()
    {
        return "id "+this.id+"\ncustomerId "+this.customerId+"\nrestaurantId "+this.restaurantId+"\n totalPrice"+this.totalPrice+"\nStatus "+this.status;
    }
    public Order(String id, String customerId, String restaurantId, List<FoodItem> foodItems, String totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.foodItems = foodItems;
        this.totalPrice = totalPrice;
        this.status = "IN_PROGRESS";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
