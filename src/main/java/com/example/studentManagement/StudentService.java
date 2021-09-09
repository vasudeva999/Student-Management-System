package com.example.studentManagement;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void saveStudent(Student student);

    Optional<Student> findByUserName(String userName);

    Student findStudent(String userName, String password);

    void updateStudent(Student newStudent);

    void  setLoginTrue(int id);

    void setLoginFalse(int id);

    boolean findByIsLogin(int id);

    void deleteStudentById (int id);

    Student getStudentById(int id);

    boolean findByIsAdmin(int id);

}
