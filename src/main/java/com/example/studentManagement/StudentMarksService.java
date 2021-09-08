package com.example.studentManagement;

import java.util.List;
import java.util.Optional;

public interface StudentMarksService {

    List<StudentMarks> getByStudentMarks(int id);

    Iterable<StudentMarks> getAllStudentsMarks();

    void saveStudentMarks(StudentMarks studentMarks);

    Optional<Integer> findById(int id);

    void updateMarkList(StudentMarks studentMarks);

    void deleteMarksById(int id);

}
