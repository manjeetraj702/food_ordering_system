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
    public static void main(String[] args) throws InterruptedException {
        UserController userController = new UserController();
        OrderController orderController = new OrderController();
        RestaurantController restaurantController = new RestaurantController();
        FoodItemController foodItemController = new FoodItemController();
        Scanner sc = new Scanner(System.in);
        System.out.println("                           +------------------------------------+");
        System.out.println("                           |           Food ordering app        |");
        System.out.println("                           +------------------------------------+");
        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            //  main menu
            Thread.sleep(1000);
            System.out.println("+----------------------------------+");
            System.out.println("| Please enter                     |");
            System.out.println("| 1 for SignUp                     |");
            System.out.println("| 2 for Sign in                    |");
            System.out.println("| 0 for Close Application          |");
            System.out.println("+----------------------------------+");
            System.out.print("-->");
            String inp1 = sc.next();
            inp1 = inp1.trim();
            System.out.println("--------------------------------------------------------------------------------------------------");
            if (inp1.equals("1")) {
                // sign up method
                System.out.println("\n                        ----Sign Up Page----");
                sc.nextLine();
                System.out.println("Enter  Username");
                String username;
                while (true) {
                    System.out.print("-->");
                    username = sc.nextLine();
                    username = username.trim();
                    if (username.equals("")) {
                        System.out.println("You enter blank username");
                        continue;
                    }
                    break;
                }
                System.out.println("Enter password");
                String password;
                do {
                System.out.print("-->");
                    password = sc.next();
                } while (!Helper.validate_password(password));

                System.out.println("Enter email");
                String email;
                do {
                System.out.print("-->");
                    email = sc.next();
                } while (!Helper.validate_emailId(email));
                System.out.println("what is your role?");
                System.out.println("Enter \n1 for owner \n2 for customer  ");
                String role;
                while (true) {
                    System.out.print("-->");
                    role = sc.next();
                    if (role.equals("1")) {
                        role = "OWNER";
                        break;
                    } else if (role.equals("2")) {
                        role = "CUSTOMER";
                        break;
                    } else {
                        System.out.println("please enter valid option");
                    }
                }

                System.out.println(userController.register(username, password, email, role) + "\n");
            } else if (inp1.equals("2")) {
                // sign in method
                System.out.println("\n                        ----Sign in Page----");
                sc.nextLine();
                System.out.println("Enter  Username");
                String username;
                while (true) {
                    System.out.print("-->");
                    username = sc.nextLine();
                    username = username.trim();
                    if (username.equals("")) {
                        System.out.println("You enter blank username\n\n");
                        continue;
                    }
                    break;
                }
                System.out.println("Enter password");
                String password;
                do {
                System.out.print("-->");
                    password = sc.next();
                } while (!Helper.validate_password(password));
                User user = userController.login(username, password);
                System.out.println("--------------------------------------------------------------------------------------------------");
                if (user != null && user.getRole().equals("OWNER")) {
                    while (true) {
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        Thread.sleep(500);
                        System.out.println("+-------------------------------------------+");
                        System.out.println("please enter                                |");
                        System.out.println("| 1 for create restaurant                   |");
                        System.out.println("| 2 for update Restaurant                   |");
                        System.out.println("| 3 for delete restaurant                   |");
                        System.out.println("| 4 for get all details of restaurant       |");
                        System.out.println("| 5 for add food Items in restaurant        |");
                        System.out.println("| 6 for update food item                    |");
                        System.out.println("| 7 for update order status                 |");
                        System.out.println("| 8 get all orders of restaurant            |");
                        System.out.println("| 0 for Log out                             |");
                        System.out.println("+-------------------------------------------+");
                        Restaurant restaurant1 = restaurantController.getRestaurantByOwnerId(user.getId());
                        System.out.print("-->");
                        String inp2 = sc.next();
                        inp2 = inp2.trim();
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        if (inp2.equals("1")) {
                            // to create restaurant
//                        String ownerId, String name, String address, String phone
                            if (restaurant1 != null) {
                                System.out.println("This user have already created Restaurant\n");
                                continue;
                            }
                            System.out.println("\n                        ----Restaurant creating Page----");
                            sc.nextLine();
                            System.out.println("Enter Name of Restaurant");
                            String name;
                            while (true) {
                                System.out.print("-->");
                                name = sc.nextLine();
                                name = name.trim();
                                if (name.equals("")) {
                                    System.out.println("You enter blank restaurant name\n");
                                    continue;
                                }
                                break;
                            }
                            System.out.println("Enter your Restaurant address");
                            String address;
                            while (true) {
                                System.out.print("-->");
                                address = sc.nextLine();
                                address = address.trim();
                                if (address.equals("")) {
                                    System.out.println("you have enter blank address\n");
                                    continue;
                                }
                                break;
                            }
                            System.out.println("Enter your phone no");
                            String phone;
                            do {
                                phone = sc.next();
                            } while (!Helper.validate_phoneNo(phone));
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
                            System.out.println("\n                        ----Restaurant update Page----");
                            System.out.println("Enter Name of Restaurant");
                            String name;
                            while (true) {
                                System.out.print("-->");
                                name = sc.nextLine();
                                name = name.trim();
                                if (name.equals("")) {
                                    System.out.println("you have enter blank\n");
                                    continue;
                                }
                                break;

                            }
                            System.out.println("Enter your Restaurant address");
                            String address;
                            while (true) {
                                System.out.print("-->");
                                address = sc.nextLine();
                                address = address.trim();
                                if (address.equals("")) {
                                    System.out.println("you have enter blank address\n");
                                    continue;
                                }
                                break;
                            }
                            restaurantController.updateRestaurant(user.getId(), restaurant1.getId(), name, address);
                        } else if (inp2.equals("3")) {
                            // to delete restaurant
                            if (restaurant1 == null) {
                                System.out.println(" There is no Restaurant at this userId\n");
                                continue;
                            }
                            restaurantController.deleteRestaurant(user.getId(), restaurant1.getId());
                            System.out.println("Restaurant deleted");
                        } else if (inp2.equals("4")) {
                            // to get all details of restaurant
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant\n");
                                continue;
                            }
                            System.out.println("-----------------------------");
                            System.out.printf("|Owner id :- %-15s|\n", restaurant1.getOwnerId());
                            System.out.printf("|Name     :- %-15s|\n", restaurant1.getName());
                            System.out.printf("|Address  :- %-15s|\n", restaurant1.getAddress());
                            System.out.printf("|Phone No :- %-15s|\n", restaurant1.getPhone());
                            System.out.println("-----------------------------");
                            if (restaurant1.getFoodItems().isEmpty()) {
                                continue;
                            }
                            System.out.println("\n                     Restaurant menu");
                            System.out.printf("| %-15s    %-15s  %-18s|\n", "Food Name", "Food price", "Food Description");
                            System.out.println("+-------------------------------------------------------+");
                            for (FoodItem foodItem : restaurant1.getFoodItems()) {
                                System.out.printf("| %-15s    %-15s  %-18s|\n", foodItem.getName(), foodItem.getPrice() + "/-", foodItem.getDescription());
                            }
                            System.out.println("+-------------------------------------------------------+");
                        } else if (inp2.equals("5")) {
                            // to add food items in restaurant
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant\n");
                                continue;
                            }
                            System.out.println("How many food items you want to add ?");
                            System.out.print("-->");
                            int num = sc.nextInt();
                            List<FoodItem> foodItems = new ArrayList<>();
                            for (int i = 0; i < num; i++) {
                                //update food item
                                sc.nextLine();
                                System.out.println("Enter food item name");
                                String name;
                                while (true) {
                                    System.out.print("-->");
                                    name = sc.nextLine();
                                    name = name.trim();
                                    if (name.equals("")) {
                                        System.out.println("You enter blank name\n");
                                        continue;
                                    }
                                    break;
                                }
//                                sc.nextLine();
                                System.out.println("Enter food description");
                                String description;
                                while (true) {
                                    System.out.print("-->");
                                    description = sc.nextLine();
                                    description = description.trim();
                                    if (description.equals("")) {
                                        System.out.println("you enter blank description\n");
                                        continue;
                                    }
                                    break;
                                }
                                double p;
                                System.out.println("Enter price");
                                String price;
                                while (true) {
                                    try {
                                        System.out.print("-->");
                                        p = sc.nextLong();
                                    } catch (Exception e) {
                                        System.out.println("Please enter valid number\n");
                                        sc.nextLine();
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
                                        System.out.println("please enter (y/n)\n");
                                    }
                                }
                                foodItems.add(foodItemController.addFoodItem(user.getId(), restaurant1.getId(), name, description, price, availabilty));
                            }
                            restaurantController.addFoodItems(restaurant1.getOwnerId(), foodItems);
                        } else if (inp2.equals("6")) {
                            // to update food item
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant\n");
                                continue;
                            }
                            List<FoodItem> foodItemList = restaurant1.getFoodItems();
                            if (foodItemList.isEmpty()) {
                                System.out.println("There is not food items to update");
                                continue;
                            }
                            int i = 0;
                            System.out.println("\n                     Restaurant menu");
                            System.out.printf("| %-15s    %-15s  %-18s|\n", "Food No", "Food Name", "Food price");
                            System.out.println("+-------------------------------------------------------+");
                            for (FoodItem foodItem : foodItemList) {
                                System.out.printf("| %-15s    %-15s  %-18s|\n", ++i, foodItem.getName(), foodItem.getPrice() + "/-");
                            }
                            System.out.println("+-------------------------------------------------------+");
                            System.out.println("Enter number which food Item you wants to update\n");
                            int a;
                            while (true) {
                                try {
                                    System.out.print("-->");
                                    a = sc.nextInt();
                                    if (a < 1 || a > restaurant1.getFoodItems().size()) {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please enter valid number\n");
                                    continue;
                                }
                                break;
                            }
                            String id = "";
                            for (FoodItem foodItem : foodItemList) {
                                if (--a == 0) {
                                    id = foodItem.getId();
                                }
                            }

                            double p;
                            System.out.println("Enter price");
                            String price;
                            while (true) {
                                try {
                                    System.out.print("-->");
                                    p = sc.nextLong();
                                } catch (Exception e) {
                                    System.out.println("Please enter valid number\n");
                                    continue;
                                }
                                price = String.valueOf(p);
                                break;
                            }
                            boolean availabilty;
                            System.out.println("food availabilty (y/n)\n");
                            while (true) {
                                System.out.print("-->");
                                String check = sc.next();
                                if (check.equals("Y") || check.equals("y")) {
                                    availabilty = true;
                                    break;
                                } else if (check.equals("n") || check.equals("N")) {
                                    availabilty = false;
                                    break;
                                } else {
                                    System.out.println("please enter (y/n)\n");
                                }
                            }
                            foodItemController.updateFoodItem(user.getId(), id, price, availabilty);

                        } else if (inp2.equals("7")) {
                            // to update order status
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant\n");
                                continue;
                            }
                            List<Order> orderList = orderController.getOrdersByRestaurantId(user.getId(), restaurant1.getId());
                            if (orderList.isEmpty()) {
                                System.out.println("There is not any order");
                                continue;
                            }
                            int i = 0;

                            System.out.println("\n                     Order List ");
                            System.out.printf("| %-15s    %-15s  %-15s|\n", "Order No", "Order Id", "Order Status");
                            System.out.println("+-------------------------------------------------+");
                            for (Order order : orderList) {
                                System.out.printf("| %-15s    %-15s  %-15s|\n", ++i, order.getId(), order.getStatus());
                            }
                            System.out.println("+-------------------------------------------------+");
                            System.out.println("Enter order number ");
                            int number;
                            while (true) {
                                try {
                                    System.out.print("-->");
                                    number = sc.nextInt();
                                    if (number < 1 || number > orderList.size()) {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("please valid order number");
                                    continue;
                                }
                                break;
                            }
                            Order order = orderList.get(number - 1);
                            System.out.println("-----------------------------");
                            System.out.println("Enter                       |");
                            System.out.println("| 1 for PENDING             |");
                            System.out.println("| 2 for in  IN_PROGRESS     |");
                            System.out.println("| 3 for COMPLETED           |");
                            System.out.println("-----------------------------");
                            int a;
                            while (true) {
                                try {
                                    System.out.print("-->");
                                    a = sc.nextInt();
                                    if (a <= 0 || a > 3) {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please enter valid number\n");
                                    continue;
                                }
                                break;
                            }
                            String status;
                            if (a == 1) {
                                status = "PENDING";
                            } else if (a == 2) {
                                status = "IN_PROGRESS";
                            } else {
                                status = "COMPLETED";
                            }
                            orderController.updateOrderStatus(user.getId(), order.getId(), status);

                        } else if (inp2.equals("8")) {
                            // to get all details of restaurant orders
                            if (restaurant1 == null) {
                                System.out.println(" please first create Restaurant\n");
                                continue;
                            }
                            List<Order> orderList = orderController.getOrdersByRestaurantId(user.getId(), restaurant1.getId());
                            if (orderList.isEmpty()) {
                                System.out.println("There is not any order");
                                continue;
                            }
                            System.out.println("\n                     Order List ");
                            System.out.printf("| %-15s    %-15s  %-18s|\n", "CustomerId", "Food Name", "Food price");
                            System.out.println("+-------------------------------------------------+");
                            for (Order order : orderList) {
                                System.out.printf("| %-5s    %-15s  %-10s|\n", order.getCustomerId(), order.getId(), order.getStatus());
                                System.out.println("\n                     FoodItems order by customer");
                                System.out.printf("| %-15s    %-15s  %-10s|\n", "Food No", "Food Name", "Food price");
                                int i = 0;
                                System.out.println("+-------------------------------------------------------+");
                                for (FoodItem foodItem : order.getFoodItems()) {
                                    System.out.printf("| %-15s    %-15s  %-18s|\n", ++i, foodItem.getName(), foodItem.getPrice() + "/-");
                                }
                                System.out.println("+-------------------------------------------------------+");
                                System.out.println("+---------------------------------+");
                                System.out.println("| Total price of order is   " + order.getTotalPrice() + "/- |");
                                System.out.println("+---------------------------------+");
                            }
                            System.out.println("+-------------------------------------------------+");
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
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        Thread.sleep(800);
                        System.out.println("+---------------------------------------------+");
                        System.out.println("Enter                                         |");
                        System.out.println("| 1 for Place a order                         |");
                        System.out.println("| 2 for get your all order details            |");
                        System.out.println("| 0 for Log out                               |");
                        System.out.println("+---------------------------------------------+");
                        System.out.print("-->");
                        String inp2 = sc.next();
                        inp2 = inp2.trim();
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        if (inp2.equals("1")) {
                            // to place order by customer

                            List<Restaurant> restaurantList = restaurantController.getAllRestaurant();
                            if (restaurantList.isEmpty()) {
                                System.out.println("There is no restaurant");
                            }
                            System.out.println("From which restaurant you wants to place a order ?\n");
                            int i = 0;
                            System.out.println("\n                     Restaurant List ");
                            System.out.printf("| %-10s    %-15s  %-18s|\n", "Restaurant No", "Restaurant Id", "Restaurant Name");
                            System.out.println("+-------------------------------------------------+");
                            for (Restaurant restaurant : restaurantList) {
                                System.out.printf("| %-10s    %-15s  %-18s|\n", ++i, restaurant.getId(), restaurant.getName());
                            }
                            System.out.println("+-------------------------------------------------+");
                            System.out.println("Enter number");

                            int option;
                            while (true) {
                                try {
                                    System.out.print("-->");
                                    option = sc.nextInt();
                                    if (option <= 0 || option > restaurantList.size()) {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("please enter valid option");
                                    sc.nextLine();
                                    continue;
                                }
                                break;

                            }
                            Restaurant restaurant = restaurantList.get(option - 1);
                            double to_pri = 0;
                            List<FoodItem> foodItemList = restaurant.getFoodItems();
                            if (foodItemList.isEmpty()) {
                                System.out.println("There no food present in this restaurant");
                                continue;
                            }
                            List<FoodItem> orderFoodItemList = new ArrayList<>();
                            while (true) {
                                i = 0;

                                System.out.println("\n                     Restaurant menu");
                                System.out.printf("| %-15s    %-15s  %-15s %-15s|\n", "Food No", "Food Name", "Food price", "availability");
                                System.out.println("+-------------------------------------------------------------------+");
                                for (FoodItem foodItem : foodItemList) {
                                    String available;
                                    if (foodItem.isAvailabilty()) {
                                        available = "available";
                                    } else {
                                        available = " not available";
                                    }
                                    System.out.printf("| %-15s    %-15s  %-15s %-15s|\n", ++i, foodItem.getName(), foodItem.getPrice() + "/-", available);
                                }
                                System.out.println("+-------------------------------------------------------------------+");

                                System.out.println("Enter foodItem number to get in your order list");
                                System.out.println("Enter 0 to get total price\n");
                                int option1;
                                while (true) {
                                    try {
                                        System.out.print("-->");
                                        option1 = sc.nextInt();
                                        if (option1 < 0 || option1 > foodItemList.size()) {
                                            throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Please enter valid number");
                                        continue;
                                    }
                                    break;
                                }
                                if (option1 == 0) {
                                    System.out.println("+---------------------------+");
                                    System.out.println("| Total price is   " + to_pri + "/- |");
                                    System.out.println("+---------------------------+");
                                    break;
                                }
                                FoodItem foodItem = foodItemList.get(option1 - 1);
                                if (foodItem.isAvailabilty()) {
                                    orderFoodItemList.add(foodItem);
                                    double f_p = Double.parseDouble(foodItem.getPrice());
                                    to_pri += f_p;
                                } else {
                                    System.out.println("This food item is not available .\n ");
                                }
                            }
                            String totalPrice = String.valueOf(to_pri);
                            orderController.placeOder(user.getId(), restaurant.getId(), orderFoodItemList, totalPrice);
                        } else if (inp2.equals("2")) {
                            // to get details of all orders of customer
                            List<Order> orderList = orderController.getOrdersByCustomerId(user.getId());
                            if (orderList.isEmpty()) {
                                System.out.println("There is not any order");
                                continue;
                            }

                            System.out.println("\n                     Order List ");
                            System.out.printf("| %-15s    %-15s  %-18s|\n", "CustomerId", "Food Name", "Food price");
                            System.out.println("+-------------------------------------------------+");
                            for (Order order : orderList) {
                                System.out.printf("| %-5s    %-15s  %-10s|\n", order.getCustomerId(), order.getId(), order.getStatus());
                                System.out.println("\n                     FoodItems order by you");
                                System.out.printf("| %-15s    %-15s  %-10s|\n", "Food No", "Food Name", "Food price");
                                int i = 0;
                                System.out.println("+-------------------------------------------------------+");
                                for (FoodItem foodItem : order.getFoodItems()) {
                                    System.out.printf("| %-15s    %-15s  %-18s|\n", ++i, foodItem.getName(), foodItem.getPrice() + "/-");
                                }
                                System.out.println("+-------------------------------------------------------+");
                                System.out.println("+----------------------------------+");
                                System.out.println("| Total price of order is   " + order.getTotalPrice() + "/- |");
                                System.out.println("+----------------------------------+");
                            }
                            System.out.println("+-------------------------------------------------+");
                        } else if (inp2.equals("0")) {
                            // to log out
                            break;
                        } else {
                            System.out.println("Invalid entry\n");
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
