package com.example.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {

//		SpringApplication.run(StudentManagementApplication.class, args);

		Scanner sc = new Scanner(System.in);

		System.out.println("\n---------_Student Marks Management System_----------\n");
		System.out.println("Choose an option...\n1. Login\n2. Register\n3. Forgot Password\n4. Exit");

		int option = sc.nextInt();

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		LoginForm loginForm = context.getBean(LoginForm.class);
		RegisterForm regForm = context.getBean(RegisterForm.class);
		Student student = new Student();

		while (true) {
			if (option == 1) {
				loginForm.login(student);
			}else if (option == 2){
				String choice = regForm.register();
				student.setName(regForm.getName());
				student.setPassword(regForm.getPassword());
				student.setEmail(regForm.getEmail());
				if (choice.equals("login")) {
					loginForm.login(student);
				}
				break;
			}else if(option==3){
				System.out.println("Case 3 not implemented...");
			}else{
				break;
			}

		}



	}

}
