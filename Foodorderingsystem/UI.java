package Foodorderingsystem;

import Foodorderingsystem.controller.FoodItemController;
import Foodorderingsystem.controller.OrderController;
import Foodorderingsystem.controller.RestaurantController;
import Foodorderingsystem.controller.UserController;
import Foodorderingsystem.model.FoodItem;
import Foodorderingsystem.model.Order;
import Foodorderingsystem.model.Restaurant;
import Foodorderingsystem.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        UserController userController = new UserController();
        OrderController orderController = new OrderController();
        RestaurantController restaurantController = new RestaurantController();
        FoodItemController foodItemController = new FoodItemController();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n         ---------------Food ordering app------------\n\n");
        while (true) {
            System.out.println("Please enter \n1 for SignUp \n2 for Sign in \n0 for Close Application");
            String inp1 = sc.next();
            inp1 = inp1.trim();
            if (inp1.equals("1")) {
                sc.nextLine();
                System.out.println("Enter  Username");
                String username = sc.nextLine();
                System.out.println("Enter password");
                String password = sc.next();
                System.out.println("Enter email");
                String email = sc.next();
                System.out.println("if you are Owner choose 1 or enter else");
                String role = sc.next();
                if (role.equals("1")) {
                    role = "OWNER";
                } else {
                    role = "CUSTOMER";
                }

                System.out.println(userController.register(username, password, email, role) + "\n");
            } else if (inp1.equals("2")) {
                sc.nextLine();
                System.out.println("Enter  Username");
                String username = sc.nextLine();
                System.out.println("Enter password");
                String password = sc.next();
                User user = userController.login(username, password);
                if (user != null && user.getRole().equals("OWNER")) {
                    while (true) {
                        System.out.println("please enter \n1 for create restaurant \n2 for update Restaurant \n3 for delete restaurant  ");
                        System.out.println("4 for get all details of restaurant \n5 for add food Items in restaurant \n6 for update food item");
                        System.out.println("7 for update order status \n8 get all orders of restaurant \n0 for Log out");
                        Restaurant restaurant1 = restaurantController.getRestaurantByOwnerId(user.getId());
                        String inp2 = sc.next();
                        inp2 = inp2.trim();
                        if (inp2.equals("1")) {
                            // to create restaurant
//                        String ownerId, String name, String address, String phone
                            if (restaurant1 != null) {
                                System.out.println("This user have already created Restaurant");
                                continue;
                            }
                            sc.nextLine();
                            System.out.println("Enter Name of Restaurant");
                            String name = sc.nextLine();
                            System.out.println("Enter your Restaurant address");
                            String address = sc.nextLine();
                            System.out.println("Enter your phone no");
                            String phone;
                            while (true) {
                                long p;
                                try {
                                    p = sc.nextLong();
                                } catch (Exception e) {
                                    sc.nextLine();
                                    System.out.println("Please enter valid number");
                                    continue;
                                }
                                phone = String.valueOf(p);
                                if (phone.length() == 10) {
                                    break;
                                }
                                System.out.println("Please enter 10 digit number");
                            }
                            Restaurant restaurant = restaurantController.createRestaurant(user.getId(), name, address, phone);
                            if (restaurant != null) {
                                System.out.println("your restaurant " + name + " Created");
                            }
                        } else if (inp2.equals("2")) {
                            // to update restaurant
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant");
                                continue;
                            }
                            // String restaurantId, String name, String address
                            System.out.println("Enter Name of Restaurant");
                            String name = sc.nextLine();
//                            sc.nextLine();
                            System.out.println("Enter your Restaurant address");
                            String address = sc.nextLine();
                            restaurantController.updateRestaurant(restaurant1.getId(), name, address);
                        } else if (inp2.equals("3")) {
                            // to delete restaurant
                            if (restaurant1 == null) {
                                System.out.println(" There is no Restaurant at this userId");
                                continue;
                            }
                            restaurantController.deleteRestaurant(restaurant1.getId());
                            System.out.println("Restaurant deleted");
                        } else if (inp2.equals("4")) {
                            // to get all details of restaurant
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant");
                                continue;
                            }
                            System.out.println("Owner id = " + restaurant1.getOwnerId() + "\nRestaurant Name = " + restaurant1.getName());
                            System.out.println("Restaurant address = " + restaurant1.getAddress() + "\nRestaurant phoneNO =" + restaurant1.getPhone());
                            System.out.println("Restaurant menu");
                            for (FoodItem foodItem : restaurant1.getFoodItems()) {
                                System.out.println(foodItem.getName() + "  " + foodItem.getPrice() + "/-");
                            }
                        } else if (inp2.equals("5")) {
                            // to add food items in restaurant
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant");
                                continue;
                            }
                            System.out.println("How many food items you want to add ?");
                            int num = sc.nextInt();
                            List<FoodItem> foodItems = new ArrayList<>();
                            for (int i = 0; i < num; i++) {
                                //update food item
                                //String restaurantId, String name, String description, String price, boolean availabilty
                                sc.nextLine();
                                System.out.println("Enter food item name");
                                String name = sc.nextLine();
                                sc.nextLine();
                                System.out.println("Enter food description");
                                String description = sc.nextLine();
                                double p;
                                System.out.println("Enter price");
                                String price;
                                while (true) {
                                    try {
                                        p = sc.nextLong();
                                    } catch (Exception e) {
                                        System.out.println("Please enter valid number");
                                        continue;
                                    }
                                    price = String.valueOf(p);
                                    break;
                                }
                                boolean availabilty;
                                System.out.println("food availabilty (y/n)");
                                while (true) {
                                    String check = sc.next();
                                    if (check.equals("Y") || check.equals("y")) {
                                        availabilty = true;
                                        break;
                                    } else if (check.equals("n") || check.equals("N")) {
                                        availabilty = false;
                                        break;
                                    } else {
                                        System.out.println("please enter (y/n)");
                                    }
                                }
                                foodItems.add(foodItemController.addFoodItem(restaurant1.getId(), name, description, price, availabilty));
                            }
                            restaurantController.addFoodItems(restaurant1.getOwnerId(), foodItems);
                        } else if (inp2.equals("6")) {
                            // to update food item
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant");
                                continue;
                            }
//                            String foodItemId,String price,boolean availabilty
                            int i = 0;
                            for (FoodItem foodItem : restaurant1.getFoodItems()) {
                                System.out.println(++i);
                                System.out.println(" Name =" + foodItem.getName());
                            }
                            System.out.println("Enter number which food Item you wants to update");
                            int a;
                            while (true) {
                                try {
                                    a = sc.nextInt();
                                    if (a <= 0 && a > restaurant1.getFoodItems().size()) {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please enter valid number");
                                    continue;
                                }
                                break;
                            }
                            String id = "";
                            for (FoodItem foodItem : restaurant1.getFoodItems()) {
                                if (--a == 0) {
                                    id = foodItem.getId();
                                }
                            }

                            double p;
                            System.out.println("Enter price");
                            String price;
                            while (true) {
                                try {
                                    p = sc.nextLong();
                                } catch (Exception e) {
                                    System.out.println("Please enter valid number");
                                    continue;
                                }
                                price = String.valueOf(p);
                                break;
                            }
                            boolean availabilty;
                            System.out.println("food availabilty (y/n)");
                            while (true) {
                                String check = sc.next();
                                if (check.equals("Y") || check.equals("y")) {
                                    availabilty = true;
                                    break;
                                } else if (check.equals("n") || check.equals("N")) {
                                    availabilty = false;
                                    break;
                                } else {
                                    System.out.println("please enter (y/n)");
                                }
                            }
                            foodItemController.updateFoodItem(id, price, availabilty);

                        } else if (inp2.equals("7")) {
                            // to update order status
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant");
                                continue;
                            }
                            List<Order> orderList = orderController.getOrdersByRestaurantId(restaurant1.getId());
                            System.out.println(" OrderId           OrderStatus");
                            for (Order order : orderList) {
                                System.out.println(" " + order.getId() + "       " + order.getStatus());
                            }
                            System.out.println("Enter order Id ");
                            String id = sc.next();
                            System.out.println("Enter \n1 for PENDING \n2 for in  IN_PROGRESS \n 3 for COMPLETED");
                            int a;
                            while (true) {
                                try {
                                    a = sc.nextInt();
                                    if (a <= 0 && a > 4) {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please enter valid number");
                                    continue;
                                }
                                break;
                            }
                            String status;
                            if (a == 1) {
                                status = "PENDING";
                            } else if (a == 2) {
                                status = "IN_PROGRESS";
                            } else if (a == 3) {
                                status = "COMPLETED";
                            } else {
                                status = "error";
                            }
                            orderController.updateOrderStatus(id, status);

                        } else if (inp2.equals("8")) {
                            // to get all details of restaurant orders
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant");
                                continue;
                            }
                            List<Order> orderList = orderController.getOrdersByRestaurantId(restaurant1.getId());
                            for (Order order : orderList) {
                                System.out.println(order);
                                System.out.println(" FoodName          price");
                                for (FoodItem foodItem : order.getFoodItems()) {
                                    System.out.println(" " + foodItem.getName() + "     " + foodItem.getPrice() + "/-");
                                }
                            }
                        } else if (inp2.equals("0")) {
                            // to log out
                            break;
                        } else {
                            System.out.println("Invalid entry");
                        }
                    }
                    //Customer methods
                } else if (user != null && user.getRole().equals("CUSTOMER")) {
                    while (true) {
                        System.out.println("Enter \n1 for Place a order \n2 for get your all order details \n0 for Log out");
                        String inp2 = sc.next();
                        inp2 = inp2.trim();
                        if (inp2.equals("1")) {
                            // to place order by customer
//                            String customerId, String restaurantId, List<FoodItem> foodItems, String totalPrice
                            String id = user.getId();
                            List<Restaurant> restaurantList = restaurantController.getAllRestaurant();
                            System.out.println("From which restaurant you wants to place a order \n");
                            int i = 0;
                            for (Restaurant restaurant : restaurantList) {
                                System.out.println(++i);
                                System.out.println(restaurant.getName());
                            }
                            System.out.println("Enter number");
                            int option = sc.nextInt();
                            Restaurant restaurant = restaurantList.get(option - 1);
                            System.out.println(" FoodName          price");
                            double to_pri = 0;
                            List<FoodItem> foodItemList = restaurant.getFoodItems();
                            List<FoodItem> orderFoodItemList = new ArrayList<>();
                            while (true) {
                                int i1 = 0;
                                for (FoodItem foodItem : foodItemList) {
                                    System.out.println(++i + " ");
                                    System.out.println(" " + foodItem.getName() + "     " + foodItem.getPrice() + "/-");
                                }
                                System.out.println("Enter foodItem number to get in your order list");
                                System.out.println("Enter 0 to get total price");
                                int option1;
                                while (true) {
                                    try {
                                        option1 = sc.nextInt();
                                        if (option1 < 0 && option1 > foodItemList.size()) {
                                            throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Please enter valid number");
                                        continue;
                                    }
                                    break;
                                }
                                if (option1 == 0) {
                                    System.out.println("your total price is " + to_pri);
                                    break;
                                }
                                FoodItem foodItem = foodItemList.get(option1 - 1);
                                orderFoodItemList.add(foodItem);
                                double f_p = Double.valueOf(foodItem.getPrice());
                                to_pri += f_p;
                            }
                            String totalPrice = String.valueOf(to_pri);
                            orderController.placeOder(user.getId(), restaurant.getId(), orderFoodItemList, totalPrice);
                        } else if (inp2.equals("2")) {
                            // to get details of all orders of customer
                            List<Order> orderList = orderController.getOrdersByCustomerId(user.getId());
                            for (Order order : orderList) {
                                System.out.println(order);
                                System.out.println(" FoodName          price");
                                for (FoodItem foodItem : order.getFoodItems()) {
                                    System.out.println(" " + foodItem.getName() + "     " + foodItem.getPrice() + "/-");
                                }
                            }
                        } else if (inp2.equals("0")) {
                            // to log out
                            break;
                        } else {
                            System.out.println("Invalid entry");
                        }
                    }
                }
            } else if (inp1.equals("0")) {
                // to close application
                break;
            } else {
                System.out.println("Invalid entry");
            }
        }
    }
}
