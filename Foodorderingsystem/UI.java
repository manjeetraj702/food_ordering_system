package Foodorderingsystem;

import Foodorderingsystem.controller.FoodItemController;
import Foodorderingsystem.controller.OrderController;
import Foodorderingsystem.controller.RestaurantController;
import Foodorderingsystem.controller.UserController;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        UserController userController=new UserController();
        OrderController orderController=new OrderController();
        RestaurantController restaurantController=new RestaurantController();
        FoodItemController foodItemController=new FoodItemController();
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\n         ---------------Food ordering app------------\n\n");
        while (true)
        {
            System.out.println("Please enter \n1 for SignUp \n2 for Sign in \n0 for Close Application");
            String inp1= sc.next();
            if(inp1.equals("1"))
            {
                sc.nextLine();
                System.out.println("Enter  Username");
                String username=sc.nextLine();
                System.out.println("Enter password");
                String password=sc.next();
                System.out.println("Enter email");
                String email=sc.next();
                System.out.println("if you are Owner choose 1 or enter else\n");
                String role=sc.next();
                if(role.equals("1"))
                {
                    role="OWNER";
                }
                else{
                    role="CUSTOMER";
                }

                System.out.println(userController.register(username,password,email,role));
            }
            else if(inp1.equals("2"))
            {
                sc.nextLine();
                System.out.println("Enter  Username");
                String username=sc.nextLine();
                System.out.println("Enter password");
                String password=sc.next();
                String check=userController.login(username,password);
                System.out.println(check);
                if(check.equals("Successfully login as owner"))
                {
                    System.out.println();
                }
            }
            else if(inp1.equals("0"))
            {
                break;
            }
            else {
                System.out.println("Invalid entry");
            }
        }
    }
}
