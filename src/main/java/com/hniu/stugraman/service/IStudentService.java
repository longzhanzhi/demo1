package com.hniu.stugraman.service;

import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.User;

public interface IStudentService {
    Student findScore(User user);

    Student findAll(User user);

    Student getTeById(String id);

    void update(Student student);
}
