package com.hniu.stugraman.dao.impl;

import com.hniu.stugraman.dao.IStudentDao;
import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    JdbcTemplate jtl = new JdbcTemplate(JDBCUtils.getDataSource());
    String sql;
    @Override
    public Student findStudent(User user) {
        sql = "select * from student where number = ?";
        try {
            return jtl.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),user.getUsername());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<EScore> findScore(int id) {
        sql = "SELECT e.`id` id , c.`name` courseName , e.`score` score FROM escore e , course c WHERE e.`courseid` = c.`id` AND e.`studentid` = ?";

        try {
            return jtl.query(sql,new BeanPropertyRowMapper<>(EScore.class),id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Student getTeById(int id) {
        sql="select * from student where id = ?";
        List<Student> query = jtl.query(sql, new BeanPropertyRowMapper<>(Student.class), id);
        if (query.size()>0){
            return query.get(0);
        }
        return null;
}

    @Override
    public void update(Student student) {
        sql = "update student set number= ?,name=?,sex=?,phone=?,qq=? where id  =?";
        int update = jtl.update(sql, student.getNumber(), student.getName(), student.getSex(), student.getPhone(), student.getQq(), student.getId());
        System.out.println(update);
    }
}
