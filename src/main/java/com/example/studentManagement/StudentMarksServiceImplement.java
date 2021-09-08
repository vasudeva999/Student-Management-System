package com.example.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentMarksServiceImplement implements StudentMarksService {

    @Autowired
    private StudentMarksRepository studentMarksRepo;

    @Override
    public List<StudentMarks> getByStudentMarks(int id){return studentMarksRepo.findByStudentId(id);}

    @Override
    public Iterable<StudentMarks> getAllStudentsMarks(){return studentMarksRepo.findAll();}

    @Override
    public void saveStudentMarks(StudentMarks studentMarks){studentMarksRepo.save(studentMarks);}

    @Override
    public Optional<Integer> findById(int id){return studentMarksRepo.findById(id);}

    @Override
    public void updateMarkList(StudentMarks studentMarks){
        studentMarksRepo.updateMarkList(studentMarks.getId(), studentMarks.getTelugu(),
                studentMarks.getHindi(), studentMarks.getEnglish(), studentMarks.getMaths(), studentMarks.getTotal());
    }

    @Override
    public void deleteMarksById(int id){studentMarksRepo.deleteById(id);}

}
