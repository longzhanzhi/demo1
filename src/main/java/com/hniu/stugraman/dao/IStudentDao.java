package com.hniu.stugraman.dao;

import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.User;

import java.util.List;

public interface IStudentDao {
    Student findStudent(User user);

    List<EScore> findScore(int id);

    Student getTeById(int id);

    void update(Student student);
}
