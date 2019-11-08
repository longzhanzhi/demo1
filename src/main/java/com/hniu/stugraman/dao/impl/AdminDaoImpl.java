package com.hniu.stugraman.dao.impl;

import com.hniu.stugraman.dao.IAdminDao;
import com.hniu.stugraman.model.Course;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdminDaoImpl implements IAdminDao {
    JdbcTemplate jtl = new JdbcTemplate(JDBCUtils.getDataSource());
    String sql;
    @Override
    public List<Course> findCource() {
        sql = "select * from course";
        return jtl.query(sql,new BeanPropertyRowMapper<Course>(Course.class));
    }

@Override
public List<User> findAccount() {
    sql = "select * from user";
    return jtl.query(sql,new BeanPropertyRowMapper<User>(User.class));
}

    @Override
    public List<Teacher> findAllTeacher() {
        sql = "select * from Teacher";
        try {
            return jtl.query(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
