package com.hniu.stugraman.dao;

import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;

import java.util.List;

public interface ITeacherDao {
    List<Student> findStudent();

    List<EScore> findScore(int id);

    Teacher findOne(User user);
    Teacher getTeById(int id);
    void updateTea(Teacher t );
}
