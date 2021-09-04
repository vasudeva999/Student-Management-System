package com.example.studentManagement;

import java.util.List;
import java.util.Optional;
import com.example.studentManagement.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplement implements StudentService{

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void saveStudent(Student student) {studentRepo.save(student);}

    @Override
    public void deleteStudentById(int id) {studentRepo.deleteById(id);}

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        Optional<Student> studentList = studentRepo.findById(id);
        return (studentList.isPresent())?student=studentList.get():student;
    }

}