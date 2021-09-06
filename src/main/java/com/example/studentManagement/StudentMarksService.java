package com.example.studentManagement;

import java.util.List;
import java.util.Optional;

public interface StudentMarksService {

    List<StudentMarks> getByStudentMarks(int id);

    List<StudentMarks> getAllStudentsMarks();

    void saveStudentMarks(StudentMarks studentMarks);

    Optional<StudentMarks> findById(int id);

    void updateMarkList(StudentMarks studentMarks);

    boolean findByAdmin(int id);
}
