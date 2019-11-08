package com.hniu.stugraman.service;

import com.hniu.stugraman.model.Course;
import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;

import java.util.List;

public interface IAdminService {
    List<Course> findCource();

    List<User> findAccount();

    List<Teacher> findAllTeacher();
}
