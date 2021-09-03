package com.example.studentManagement;

import java.util.List;
import com.example.studentManagement.Student;

public interface StudentService {

    List<Student> getAllStudents();

    void saveStudent(Student student);

    void deleteStudentById (int id);

    Student getStudentById(int id);

}
