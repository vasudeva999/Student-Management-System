package com.example.studentManagement;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student findStudent(String userName, String password);

    void updateStudent(Student newStudent);

    void deleteStudentById (int id);

    Student getStudentById(int id);

    List<StudentMarks> getStudentMarks(int id);

}
