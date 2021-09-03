package com.example.studentManagement;

import java.util.Scanner;

public class LoginForm {

    public void login(Student regForm){

        Scanner sc = new Scanner(System.in);

        System.out.println("User Login From");
        while (true) {
            System.out.println("Enter your name :");
            String name = sc.nextLine();

            System.out.println("Enter your Password :");
            String password = sc.nextLine();

            if (!regForm.getName().equals(null) && !regForm.getPassword().equals(null)) {
                if (regForm.getName().equals(name) && regForm.getPassword().equals(password)) {
                    System.out.println("User - " + name + " Login Successfully...\n");
                    break;
                }
            }
            else{
                System.out.println("User name or password is wrong..\n1. Try Again\n2. Quit");
                int option = sc.nextInt();
                if (option==2) break;
            }
        }

    }
}
