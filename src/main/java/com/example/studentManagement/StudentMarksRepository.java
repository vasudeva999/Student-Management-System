package com.example.studentManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {

    @Query(value = "Select * from STUDENT_MARKS where ID=?1", nativeQuery = true)
    List<StudentMarks> findByStudentId(int id);

    @Modifying
    @Transactional
    @Query(value = "update student_marks set telugu=?2, hindi=?3, english=?4, maths=?5, total=?6 where id=?1", nativeQuery = true)
    void updateMarkList(int id, int telugu, int hindi, int english, int maths, int total);

    @Query(value = "Select total from student_marks where id=?1", nativeQuery = true)
    Optional<Integer> findById(int id);

}
