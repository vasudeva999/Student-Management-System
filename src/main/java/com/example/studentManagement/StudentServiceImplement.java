package com.example.studentManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplement implements StudentService{

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public void saveStudent(Student student) {studentRepo.save(student);}

    @Override
    public void  updateStudent(Student newStudent){
        String userName = newStudent.getUserName();
        String firstName = newStudent.getFirstName();
        String lastName = newStudent.getLastName();
        String email = newStudent.getEmail();
        String password = newStudent.getPassword();
        int id = newStudent.getId();
        studentRepo.updateStudent(userName, firstName, lastName, email, password, id);
    }

    @Override
    public Student findStudent(String userName, String password){return studentRepo.findByNameAndPassword(userName, password);}

    @Override
    public void deleteStudentById(int id) {studentRepo.deleteById(id);}

    @Override
    public Student getStudentById(int id) {
        Student student = null;

        Optional<Student> studentList = studentRepo.findById(id);
        return (studentList.isPresent())?student=studentList.get():student;
    }

    @Override
    public void setLoginTrue(int id){studentRepo.setLoginTrue(id);}

    @Override
    public void setLoginFalse(int id){studentRepo.setLoginFalse(id);}

    @Override
    public boolean findByIsAdmin(int id){return studentRepo.findByIsAdmin(id);}

    @Override
    public Optional<Student> findByUserName(String userName){return studentRepo.findByUserName(userName);}

    @Override
    public boolean findByIsLogin(int id){return studentRepo.findByIsLogin(id);}
}