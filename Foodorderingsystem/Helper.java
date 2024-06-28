package Foodorderingsystem;

import java.util.Scanner;

public class Helper {
    static Scanner sc = new Scanner(System.in);

    public static boolean validate_phoneNo(String phoneNo) {
        try {
            if (phoneNo.length() != 10) {
                throw new Exception();
            }
            Long.parseLong(phoneNo);
            return true;
        } catch (Exception e) {
            System.out.println("Please enter valid phoneNo");
        }
        return false;
    }

    public static boolean validate_password(String password) {
        if (password.length() < 8) {
            System.out.println("Password size is less than 8");
            return false;
        }
        int num = 0, upch = 0, lowch = 0, sch = 0;
        int check = 0;
        for (int i = 0; i < password.length() && check == 0; i++) {
            int a = Character.getType(password.charAt(i));
            if (a == 1) {
                upch = 1;
            } else if (a == 2) {
                lowch = 1;
            } else if (a == 9) {
                num = 1;
            } else {
                sch = 1;
            }
            check = upch * lowch * num * sch;

        }
        if (check == 1) {
            return true;
        }
        System.out.println("Please enter valid password (containing at least 1 uppercase ,1 lowercase,1 special character and 1 number");
        return false;
    }


    public static boolean validate_emailId(String email) {
        int check_front = 0;
        int check_back = 0;
        int check_at = 0;
        int check_dot = 0;
        for (int i = 0; i < email.length(); i++) {
            char a = email.charAt(i);
            int type = Character.getType(a);
            if (type == 1 || type == 2 && check_front == 0) {
                check_front = 1;
                continue;
            }
            if (a == '@' && check_front == 1 && check_at == 0) {
                check_at = 1;
                continue;
            }
            if (check_at == 1 && check_back == 0) {
                check_back = 1;
                continue;
            }
            if (check_back == 1) {
                check_dot = 1;
                break;
            }
        }
        if(check_dot == 1){
            return true;
        }
        System.out.println("please enter a valid email id (example:-chotu@gamil.com)");
return false;
    }
}
