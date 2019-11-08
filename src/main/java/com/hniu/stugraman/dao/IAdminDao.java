package com.hniu.stugraman.dao;

import com.hniu.stugraman.model.Course;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;

import java.util.List;

public interface IAdminDao {
    List<Course> findCource();

    List<User> findAccount();

    List<Teacher> findAllTeacher();
}
