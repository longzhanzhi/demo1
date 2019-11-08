package com.hniu.stugraman.dao.impl;

import com.hniu.stugraman.dao.ITeacherDao;
import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TeacherDaoImpl implements ITeacherDao {
@Override
public void updateTea(Teacher t) {
    sql = "update teacher set number= ?,name=?,sex=?,phone=?,qq=? where id  =?";
    int update = jtl.update(sql, t.getNumber(), t.getName(), t.getSex(), t.getPhone(), t.getQq(), t.getId());
    System.out.println(update);
}

    @Override
    public Teacher getTeById(int id) {
        sql="select * from teacher where id = ?";
        List<Teacher> query = jtl.query(sql, new BeanPropertyRowMapper<>(Teacher.class), id);
        if (query.size()>0){
            return query.get(0);
        }
        return null;
    }

    JdbcTemplate jtl = new JdbcTemplate(JDBCUtils.getDataSource());
    String sql;
    @Override
    public List<Student> findStudent() {
        sql = "select * from student";
        try {
            return jtl.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
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
    public Teacher findOne(User user) {
        sql = "select * from Teacher where number = ?";
        try {
            return jtl.queryForObject(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class),user.getUsername());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
