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
    public ModelAndView login(LoginForm login) {
        System.out.println("Login form Running...");

        Student student = studentService.findStudent(login.getUserName(), login.getPassword());

        ModelAndView mv = new ModelAndView();

        if (student!=null && login.getUserName()!=null) {
            if (student.getUserName().equalsIgnoreCase(login.getUserName()) &&
                    student.getPassword().equalsIgnoreCase(login.getPassword())) {
                if (student.isAdmin()) {
                    mv.setViewName("redirect:/adminHome-" + student.getId());
                    return mv;
                }
                mv.setViewName("redirect:/studentHome-" + student.getId());
                return mv;
            }

        }
        if (student==null && login.getUserName()!=null) mv.addObject("exists", "UserName or Password is wrong");

        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("register")
    public ModelAndView register(Student student){
        System.out.println("Register form Running...");

        ModelAndView mv = new ModelAndView();

        Optional<Student> userName = studentService.findByUserName(student.getUserName());

        System.out.println(userName);
        if (student.getUserName()!=null && userName.isEmpty()) {
            studentService.saveStudent(student);
            mv.setViewName("redirect:/login");
            return mv;
        }

        if (!userName.isEmpty()) mv.addObject("exists", "UserName already exists.");
        mv.setViewName("register");
        return mv;
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
        System.out.println("Delete User running....");

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

        boolean isAdmin = studentService.findByIsAdmin(id);
        if (isAdmin){
            String button = "<a class='submitButton' href='adminHome-"+id+"'> Switch to Admin Page </a>";
            mv.addObject("exists", button);
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

        Optional<Integer> check = studentMarksService.findById(studentMarks.getId());
        if (studentMarks.getEnglish()!=0 && check.isEmpty()){
            studentMarks.setTotal();
            studentMarksService.saveStudentMarks(studentMarks);

            if (studentService.findByIsAdmin(id)) {
                mv.setViewName("redirect:/adminHome-" + id);
                return mv;
            }
            mv.setViewName("redirect:/studentHome-"+id);
            return mv;
        }
        mv.setViewName("marks");
        mv.addObject("id", id);
        if (studentMarks.getEnglish()!=0 && !check.isEmpty())
            mv.addObject("exists", "Student already exists");
        return mv;
    }

    @RequestMapping("updateMarkList-{id}")
    public ModelAndView updateMarkList(@PathVariable("id")int id, StudentMarks newStudentMarks){
        System.out.println("Update Mark List is Running...");

        ModelAndView mv = new ModelAndView();

        Optional<Integer> check = studentMarksService.findById(newStudentMarks.getId());
        if (newStudentMarks.getEnglish()!=0 && !(check.isEmpty())){
            System.out.println("Updated mark list found.....");
            newStudentMarks.setTotal();
            studentMarksService.updateMarkList(newStudentMarks);
            mv.setViewName("redirect:/adminHome-"+id);
            return mv;
        }
        mv.setViewName("updateMarks");
        if (newStudentMarks.getEnglish()!=0 && check.isEmpty())
            mv.addObject("exists", "Student not Exists");
        return mv;
    }

    @RequestMapping("adminHome-{id}")
    public ModelAndView adminHome(@PathVariable("id")int id){
        System.out.println("Admin Home Running...");

        Iterable<StudentMarks> allStudents = studentMarksService.getAllStudentsMarks();

        ModelAndView mv = new ModelAndView();
        mv.addObject("allStudents", allStudents);
        mv.setViewName("adminHome");
        return mv;
    }

    @RequestMapping("deleteMarks-{id}")
    public ModelAndView deleteMarks(@PathVariable("id")int id, @RequestParam(value = "sid",defaultValue = "0")int sid){
        System.out.println("Delete marks running...");

        ModelAndView mv = new ModelAndView();

        Optional<Integer> check = studentMarksService.findById(sid);

        if (check.isEmpty() && sid!=0){
            mv.addObject("exists", "Student not Exists");
        }

        if (!check.isEmpty() && sid!=0){
            System.out.println("Delete marks with student id ...");
            studentMarksService.deleteMarksById(sid);
            mv.setViewName("redirect:/adminHome-"+id);
            return mv;
        }
        mv.setViewName("deleteMarks");
        mv.addObject("id", id);
        return mv;
    }

}
