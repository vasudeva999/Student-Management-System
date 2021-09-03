package com.example.studentManagement;

import java.util.List;
import java.util.Optional;
import com.example.studentManagement.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class StudentServiceImplement implements StudentService{
    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        System.out.println("Student saved...");
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

}