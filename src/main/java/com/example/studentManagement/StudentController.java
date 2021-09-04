package com.example.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("login")
    public String login(LoginForm login) {
        System.out.println("Login form Running...");

        return "login";
    }

    @RequestMapping("register")
    public String register(Student student){
        System.out.println("Register form Running...");

        if (!(student.getUserName()==null)) {
            studentService.saveStudent(student);
            return "login";
        }
        return "register";
    }

}
