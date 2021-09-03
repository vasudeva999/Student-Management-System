package com.example.studentManagement;


import java.util.Scanner;

public class RegisterForm {

    private String name;
    private String password;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String register(){

        Scanner sc = new Scanner(System.in);

        System.out.println("User Register From");
        System.out.println("Enter your name :");
        setName(sc.nextLine());

        System.out.println("Create new Password :");
        setPassword(sc.nextLine());

        System.out.println("Re-enter your Password :");
        String password2 = sc.nextLine();

        System.out.println("Enter your Email :");
        setEmail(sc.nextLine());

        System.out.println("Successfully User - "+name+" Created...\n");
        System.out.println("Choose an option\n1. Login\n2. Quit");

        int option = sc.nextInt();

        return (option == 1)?"login":"quit";

    }
}
