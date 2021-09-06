package com.example.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMarksService studentMarksService;

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
            student.getPassword().equalsIgnoreCase(login.getPassword())) {
                if (student.isAdmin())
                    return "redirect:/adminHome-" + student.getId();
                return "redirect:/studentHome-" + student.getId();
            }
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

    @RequestMapping("profile-{id}")
    public ModelAndView profile(@PathVariable("id")int id){
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

    @RequestMapping("updateDetails-{id}")
    public ModelAndView updateDetails(@PathVariable("id")int id, Student newStudent){
        System.out.println("Update-form running...");

        ModelAndView mv = new ModelAndView();

        Student student = studentService.getStudentById(id);

        if (!(newStudent.getUserName()==null) && !(student==null)){
            System.out.println("New Student is not null....");
            newStudent.setId(student.getId());
            studentService.updateStudent(newStudent);
            mv.setViewName("redirect:/profile-"+newStudent.getId());
            return mv;
        }

        mv.addObject("student", student);
        mv.setViewName("update");
        return mv;
    }

    @RequestMapping("deleteUser-{id}")
    public String deleteUser(@PathVariable("id")int id){
        System.out.println("Delete student running....");

        studentService.deleteStudentById(id);
        return "redirect:/register";
    }

    @RequestMapping("studentHome-{id}")
    public ModelAndView studentHome(@PathVariable("id")int id){
        System.out.println("Home page Running...");

        ModelAndView mv = new ModelAndView();

        if (id==0){
            System.out.println("student need to login to access the home page");
            mv.setViewName("redirect:/register");
            return mv;
        }
        List<StudentMarks> marks = studentMarksService.getByStudentMarks(id);
        if (marks.isEmpty()){
            System.out.println("Student have no data...");
            mv.setViewName("empty");
            mv.addObject("id", id);
            return mv;
        }

        System.out.println("Student have data...");

        mv.setViewName("home");
        mv.addObject("marks", marks);
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping("createMarkList-{id}")
    public ModelAndView createMarkList(@PathVariable("id")int id, StudentMarks studentMarks){
        System.out.println("Add marks running...");

        ModelAndView mv = new ModelAndView();

        if (studentMarks.getEnglish()!=0){
            studentMarks.setTotal();
            studentMarksService.saveStudentMarks(studentMarks);

            if (studentMarksService.findByAdmin(id)) {
                mv.setViewName("redirect:/adminHome-" + id);
                return mv;
            }
            mv.setViewName("redirect:/studentHome-"+id);
            return mv;
        }
        mv.setViewName("marks");
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping("updateMarkList-{id}")
    public String updateMarkList(@PathVariable("id")int id, StudentMarks newStudentMarks){
        System.out.println("Update Mark List is Running...");

        Optional<StudentMarks> studentMarks = studentMarksService.findById(newStudentMarks.getId());

        if (newStudentMarks.getEnglish()!=0 && studentMarks!=null){
            System.out.println("Updated mark list found.....");
            newStudentMarks.setTotal();
            studentMarksService.updateMarkList(newStudentMarks);
            return "redirect:/adminHome-"+id;
        }
        return "updateMarks";
    }

    @RequestMapping("allStudents")
    public ModelAndView allStudents(){
        System.out.println("Printing all students");

        List<Student> allStudents = studentService.getAllStudents();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminHome");
        mv.addObject("allStudents", allStudents);
        return mv;
    }


    @RequestMapping("adminHome-{id}")
    public ModelAndView adminHome(@PathVariable("id")int id){
        System.out.println("Admin Home Running...");

        List<StudentMarks> allStudents = studentMarksService.getAllStudentsMarks();

        ModelAndView mv = new ModelAndView();
        mv.addObject("allStudents", allStudents);
        mv.setViewName("adminHome");
        return mv;
    }

}
