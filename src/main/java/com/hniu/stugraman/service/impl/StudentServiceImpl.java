package com.hniu.stugraman.service.impl;

import com.hniu.stugraman.dao.IStudentDao;
import com.hniu.stugraman.dao.impl.StudentDaoImpl;
import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    IStudentDao dao = new StudentDaoImpl();
    @Override
    public Student findScore(User user) {
        //查询出student对象
        Student stu =  dao.findStudent(user);
        //根据学生id查询成绩集合
        List<EScore> score = dao.findScore(stu.getId());
        stu.setScores(score);
        return stu;
    }

    @Override
    public Student findAll(User user) {
        Student stu =  dao.findStudent(user);
        return stu;
    }

    @Override
    public Student getTeById(String id) {
        return dao.getTeById(Integer.parseInt(id));
    }

    @Override
    public void update(Student student) {
        dao.update(student);
    }


}
