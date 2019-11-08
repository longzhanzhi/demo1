package com.hniu.stugraman.service;

import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;

import java.util.List;

public interface ITeacherService {
    List<Student> findAllScore();
    List<Student> findAllStudent();

    Teacher findOne(User user);
    Teacher getTeById(int id);
    void updateTea(Teacher teacher);
}
