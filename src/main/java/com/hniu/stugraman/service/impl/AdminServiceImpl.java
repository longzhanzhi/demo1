package com.hniu.stugraman.service.impl;

import com.hniu.stugraman.dao.IAdminDao;
import com.hniu.stugraman.dao.impl.AdminDaoImpl;
import com.hniu.stugraman.model.Course;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.IAdminService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {
    IAdminDao dao = new AdminDaoImpl();
    @Override
    public List<Course> findCource() {
        return dao.findCource();
    }

@Override
public List<User> findAccount() {
    return dao.findAccount();
}

@Override
public List<Teacher> findAllTeacher() {
    return dao.findAllTeacher();
}
}
