package com.example.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String main(){
        return "main";
    }

    @RequestMapping("login")
    public String login(LoginForm login) {
        System.out.println("Login form Running...");

        Student student = studentService.findStudent(login.getUserName(), login.getPassword());

        if (!(student==null) && !(login.getUserName()==null))
            if (student.getUserName().equalsIgnoreCase(login.getUserName()) &&
            student.getPassword().equalsIgnoreCase(login.getPassword()))
                return "redirect:/studentHome-"+student.getId();
        return "login";
    }

    @RequestMapping("register")
    public String register(Student student){
        System.out.println("Register form Running...");

        if (!(student.getUserName()==null)) {
            studentService.saveStudent(student);
            return "redirect:/login";
        }
        return "register";
    }

    @RequestMapping("studentProfile-{id}")
    public ModelAndView studentProfile(@PathVariable("id")int id){
        System.out.println("student-profile running....");

        Student student = studentService.getStudentById(id);

        ModelAndView mv = new ModelAndView();

        if (student==null){
            mv.setViewName("redirect:/register");
            return mv;
        }

        mv.addObject("student", student);
        mv.setViewName("profile");

        return mv;
    }

    @RequestMapping("updateStudent-{id}")
    public ModelAndView updateStudent(@PathVariable("id")int id, Student newStudent){
        System.out.println("Update-form running...");

        ModelAndView mv = new ModelAndView();

        Student student = studentService.getStudentById(id);

        if (!(newStudent.getUserName()==null) && !(student==null)){
            System.out.println("New Student is not null....");
            newStudent.setId(student.getId());
            studentService.updateStudent(newStudent);
            mv.setViewName("redirect:/studentProfile-"+newStudent.getId());
            return mv;
        }

        mv.addObject("student", student);
        mv.setViewName("update");
        return mv;
    }

    @RequestMapping("deleteStudent-{id}")
    public String deleteStudent(@PathVariable("id")int id){
        System.out.println("student-page running....");

        studentService.deleteStudentById(id);
        return "redirect:/register";
    }

    @RequestMapping("studentHome-{id}")
    public ModelAndView studentHome(@PathVariable("id")int id){
        System.out.println("Home page Running...");

        int marks = studentService.getStudentMarks(id);

        ModelAndView mv = new ModelAndView();

        if (id==0){
            System.out.println("student need to login to access the home page");
            mv.setViewName("redirect:/register");
            return mv;
        }

        if (marks==0){
            System.out.println("Student have no data...");
            mv.setViewName("empty");
            mv.addObject("id", id);
            return mv;
        }

        System.out.println(marks);
        System.out.println("Student have data...");

        mv.setViewName("home");
        mv.addObject("marks", marks);
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping("addMarks-{sid}")
    public String addMarks(@PathVariable("sid")int sid, MarksForm marksForm){
        System.out.println("Add marks running...");

        if (!(marksForm==null)){
            studentService.saveStudentMarks(marksForm);
        }

        return "marks";
    }


//    @RequestMapping("allStudents")
//    public ModelAndView allStudents(){
//        System.out.println("Printing all students");
//
//        List<Student> allstudents = studentService.getAllStudents();
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("home");
//        mv.addObject("allStudents", allStudents());
//        return mv;
//    }


}
