package com.example.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImplement studentServiceImp;

    @RequestMapping("/")
    public String viewHomePage() {
        return "Home page view...";
    }

    @RequestMapping("index")
    public String index(){
        System.out.println("Index Running...");
        return "index.html";
    }

    @RequestMapping("save")
    public String saveStudent(){
        Student student = new Student();
        studentServiceImp.saveStudent(student);
        System.out.println("Student save in controller..");
        return "Saved Student data...";
    }

}
