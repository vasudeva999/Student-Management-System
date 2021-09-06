package com.example.studentManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "Select * from STUDENT where user_name=?1 and password=?2", nativeQuery = true)
    Student findByNameAndPassword(String userName, String password);

    @Modifying
    @Transactional
    @Query(value = "Update STUDENT set user_name=?1, first_name=?2, last_name=?3, email=?4, password=?5 where id=?6",
            nativeQuery = true)
    void updateStudent(String userName, String firstName, String lastName, String email, String password, int id);

}
