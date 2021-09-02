package com.example.studentManagement;

import java.util.List;
import java.util.Optional;
import com.example.studentManagement.Student;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentServiceImplement implements StudentService{
    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public void saveStudent(Student student) {

    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public Student getStudentByID(int id) {
        return null;
    }

}