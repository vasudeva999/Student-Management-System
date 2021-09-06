package com.example.studentManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {

    @Query(value = "Select * from STUDENT_MARKS where ID=?1", nativeQuery = true)
    List<StudentMarks> findByStudentId(int id);

    @Modifying
    @Transactional
    @Query(value="Insert into student_marks(id, telugu, hindi, english, maths, total)values(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void updateMarkList(int id, int telugu, int hindi, int english, int maths, int total);

    @Query(value="select is_admin from student_marks where id=?1", nativeQuery = true)
    public boolean findByAdmin(int id);

}
